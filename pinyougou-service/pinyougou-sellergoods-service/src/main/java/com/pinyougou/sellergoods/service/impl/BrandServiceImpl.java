package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service(interfaceName = "com.pinyougou.service.BrandService")
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
//        PageInfo<Brand> pageInfo = PageHelper.startPage(1,999)
//                .doSelectPageInfo(new ISelect() {
//                    @Override
//                    public void doSelect() {
//                        brandMapper.selectAll();
//                    }
//                });
//        System.out.println("总记录数：" + pageInfo.getTotal());
//        System.out.println("总页数：" + pageInfo.getPages());
//        return pageInfo.getList();
        return brandMapper.selectAll();
    }


    public void save(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }
}
