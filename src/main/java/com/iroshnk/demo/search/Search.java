package com.iroshnk.demo.search;

import com.iroshnk.demo.api.request.SearchCriteria;
import com.iroshnk.demo.api.response.SearchResponse;
import com.iroshnk.demo.search.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public abstract class Search {
    protected String selectSQL;
    protected String countSQL;
    protected AbstractMapper rowMapper;
    protected RowMapper countMapper;
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected Search(String selectSQL, String countSQL, AbstractMapper rowMapper, RowMapper countMapper) {
        this.selectSQL = selectSQL;
        this.countSQL = countSQL;
        this.rowMapper = rowMapper;
        this.countMapper = countMapper;
    }

    public SearchResponse findByCriteria(SearchCriteria criteria) {
        SearchResponse response = new SearchResponse();
        response.offset = criteria.offset;
        response.limit = criteria.limit;
        String where = generateWhere(criteria, new StringBuilder(100), rowMapper.getColumnMap());
        String select = selectSQL + where + generateOrderBy(criteria, rowMapper.getColumnMap()) + generateLimit(criteria);
        String count = countSQL + where;
        //System.out.println(select);
        //System.out.println(count);
        try {
            response.data = this.jdbcTemplate.query(select, rowMapper);
            response.recordCount = (Integer) this.jdbcTemplate.query(count, countMapper).get(0);
            response.status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    protected String generateWhere(SearchCriteria criteria, StringBuilder where, HashMap<String, String> columnMap) {
        where.append(" WHERE 1 > 0 ");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (criteria.fromDate != null && criteria.toDate != null) {
            where.append(" AND A.created_date BETWEEN '").append(dateFormat.format(criteria.fromDate)).
                    append("' AND '").append(dateFormat.format(criteria.toDate)).append("' ");
        }
        if (criteria.statuses != null && criteria.statuses.size() > 0) {
            String statuses = criteria.statuses.toString();
            where.append(" AND A.status IN (").append(statuses.substring(1, statuses.length() - 1)).append(")");
        }
        if (criteria.searchKeys != null && criteria.searchKeys.size() > 0) {
            for (int i = 0; i < criteria.searchKeys.size(); i++) {
                String key = criteria.searchKeys.get(i);
                key = columnMap.get(key);
                Object value = criteria.values.get(i);
                switch (criteria.operators.get(i)) {
                    case "eq": {
                        where.append(" AND ").append(key).append(" = '").append(value).append("'");
                        break;
                    }
                    case "like": {
                        where.append(" AND ").append(key).append(" LIKE '%").append(value).append("%'");
                        break;
                    }
                    case "gt": {
                        where.append(" AND ").append(key).append(" > '").append(value).append("'");
                        break;
                    }
                    case "lt": {
                        where.append(" AND ").append(key).append(" < '").append(value).append("'");
                        break;
                    }
                    case "gte": {
                        where.append(" AND ").append(key).append(" >= '").append(value).append("'");
                        break;
                    }
                    case "lte": {
                        where.append(" AND ").append(key).append(" <= '").append(value).append("'");
                        break;
                    }
                }
            }
        }

        return where.toString();
    }

    protected String generateOrderBy(SearchCriteria criteria, HashMap<String, String> columnMap) {
        String orderBy = " ASC ";
        if (criteria.orderByKey != null) {
            criteria.orderByKey = columnMap.get(criteria.orderByKey);
            if (criteria.orderByKey != null) {
                if ("DESC".equalsIgnoreCase(criteria.orderByValue)) {
                    orderBy = " DESC ";
                }

                return " ORDER BY " + criteria.orderByKey + orderBy;
            }
        }

        return "";
    }

    protected String generateLimit(SearchCriteria criteria) {
        if (criteria.limit > 0) {
            return " LIMIT " + criteria.offset + "," + criteria.limit;
        } else {
            return "";
        }
    }
}
