package com.web.mapper;

import java.util.List;

import com.web.entity.Units;

/**
 * 单元表接口
 * 
 * @author lijialong
 */
public interface UnitsDao {
	/**
	 * 根据name删除单元
	 * 
	 * @param name
	 *            单元名称
	 */
	public int deleteByName(String name);
	
	/**
	 * 根据单元名称/别名查询
	 * 
	 * @param name
	 *            单元名
	 * @param otherName
	 *            单元别名
	 * @return
	 */
	public List<Units> selectByName(String name, String otherName);
}
