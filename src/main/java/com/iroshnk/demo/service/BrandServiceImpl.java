package com.iroshnk.demo.service;

import com.iroshnk.demo.model.Brand;
import com.iroshnk.demo.repository.BrandRepository;
import com.iroshnk.demo.service.inter.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;

    public Brand create(Brand brand){
        Brand brand1 = brandRepository.save(brand);

        return brand1;
    }
}
