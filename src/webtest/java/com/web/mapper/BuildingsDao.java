package com.web.mapper;

import java.util.List;

import com.web.entity.Buildings;

/**
 * 楼栋表接口
 * 
 * @author lijialong
 */
public interface BuildingsDao {
	/**
	 * 根据name删除楼栋
	 * 
	 * @param name
	 *            楼栋名称
	 */
	public int deleteByName(String name);
	
	/**
	 * 根据楼栋名称/别名查询
	 * 
	 * @param name
	 *            楼栋名
	 * @param otherName
	 *            楼栋别名
	 * @return
	 */
	public List<Buildings> selectByName(String name, String otherName);
}
