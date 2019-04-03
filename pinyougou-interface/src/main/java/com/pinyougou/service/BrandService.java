package com.pinyougou.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;

import java.io.Serializable;
import java.util.List;

public interface BrandService {
    List<Brand> findAll();

    void save(Brand brand);

    void update(Brand brand);

    PageResult findByPage(Brand brand, int page, int rows);

    void deleteAll(Serializable[] ids);
}
