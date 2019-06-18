package com.iroshnk.demo.search;

import com.iroshnk.demo.search.mapper.BrandMapper;
import com.iroshnk.demo.search.mapper.CountMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BrandSearch extends Search {
    static String SELECT_SQL = "SELECT * FROM BRAND A";
    static String COUNT_SQL = "SELECT COUNT(brandId) AS ct FROM BRAND AS A";

    public BrandSearch() {
        super(SELECT_SQL, COUNT_SQL, new BrandMapper(), new CountMapper());
    }
}
