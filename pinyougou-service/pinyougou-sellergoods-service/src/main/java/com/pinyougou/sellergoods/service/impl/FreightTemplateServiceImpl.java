package com.pinyougou.service.impl;

import com.pinyougou.pojo.FreightTemplate;
import com.pinyougou.mapper.FreightTemplateMapper;
import com.pinyougou.service.FreightTemplateService;
import java.util.List;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import java.io.Serializable;
import java.util.Arrays;
/**
 * FreightTemplateServiceImpl 服务接口实现类
 * @date 2019-03-28 20:06:11
 * @version 1.0
 */
public class FreightTemplateServiceImpl implements FreightTemplateService {

	@Autowired
	private FreightTemplateMapper freightTemplateMapper;

	/** 添加方法 */
	public void save(FreightTemplate freightTemplate){
		try {
			freightTemplateMapper.insertSelective(freightTemplate);
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/** 修改方法 */
	public void update(FreightTemplate freightTemplate){
		try {
			freightTemplateMapper.updateByPrimaryKeySelective(freightTemplate);
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/** 根据主键id删除 */
	public void delete(Serializable id){
		try {
			freightTemplateMapper.deleteByPrimaryKey(id);
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/** 批量删除 */
	public void deleteAll(Serializable[] ids){
		try {
			// 创建示范对象
			Example example = new Example(FreightTemplate.class);
			// 创建条件对象
			Example.Criteria criteria = example.createCriteria();
			// 创建In条件
			criteria.andIn("id", Arrays.asList(ids));
			// 根据示范对象删除
			freightTemplateMapper.deleteByExample(example);
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/** 根据主键id查询 */
	public FreightTemplate findOne(Serializable id){
		try {
			return freightTemplateMapper.selectByPrimaryKey(id);
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/** 查询全部 */
	public List<FreightTemplate> findAll(){
		try {
			return freightTemplateMapper.selectAll();
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/** 多条件分页查询 */
	public List<FreightTemplate> findByPage(FreightTemplate freightTemplate, int page, int rows){
		try {
			PageInfo<FreightTemplate> pageInfo = PageHelper.startPage(page, rows)
				.doSelectPageInfo(new ISelect() {
					@Override
					public void doSelect() {
						freightTemplateMapper.selectAll();
					}
				});
			return pageInfo.getList();
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

}