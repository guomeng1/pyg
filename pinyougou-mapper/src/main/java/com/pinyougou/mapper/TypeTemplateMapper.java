package com.pinyougou.mapper;

import tk.mybatis.mapper.common.Mapper;

import com.pinyougou.pojo.TypeTemplate;

import java.util.List;

/**
 * TypeTemplateMapper 数据访问接口
 * @date 2019-03-28 20:02:42
 * @version 1.0
 */
public interface TypeTemplateMapper extends Mapper<TypeTemplate>{


    List<TypeTemplate> findAll(TypeTemplate typeTemplate);
}