package com.iroshnk.demo.controller;

import com.iroshnk.demo.api.request.SearchCriteria;
import com.iroshnk.demo.api.response.SearchResponse;
import com.iroshnk.demo.model.Brand;
import com.iroshnk.demo.search.BrandSearch;
import com.iroshnk.demo.service.inter.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    BrandService brandServiceImpl;
    @Autowired
    BrandSearch brandSearch;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Brand brand) {
        Brand brand1 = brandServiceImpl.create(brand);

        return new ResponseEntity<>(brand1, HttpStatus.OK);
    }

    @RequestMapping(value = "findByCriteria", method = RequestMethod.POST)
    public ResponseEntity<?> findByCriteria(@RequestBody SearchCriteria searchCriteria,
                                    HttpServletResponse servletResponse) {
        SearchResponse response = brandSearch.findByCriteria(searchCriteria);
        if (response.status == -1) {
            servletResponse.setHeader("ETag", response.errorCode);
            return new ResponseEntity<>(response.errorCode, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
