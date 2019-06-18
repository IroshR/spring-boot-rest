package com.iroshnk.demo.search.mapper;

import com.iroshnk.demo.api.BrandApi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BrandMapper extends AbstractMapper<BrandApi> {
    public BrandMapper() {
        columnMap = new HashMap<>(1);
        columnMap.put("brandId", "A.brandId");
    }

    @Override
    public BrandApi mapRow(ResultSet row, int rowNum) throws SQLException {
        BrandApi api = new BrandApi();
        api.brandId = row.getInt("A.brandId");

        return api;
    }
}
