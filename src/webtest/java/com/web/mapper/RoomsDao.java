package com.web.mapper;

import java.util.List;

import com.web.entity.Rooms;

/**
 * 门牌号表接口
 * 
 * @author lijialong
 */
public interface RoomsDao {
	/**
	 * 根据name删除门牌号
	 * 
	 * @param name
	 *            门牌号名称
	 */
	public int deleteByName(String name);
	
	/**
	 * 根据门牌名称/别名查询
	 * 
	 * @param name
	 *            门牌名
	 * @param otherName
	 *            门牌别名
	 * @return
	 */
	public List<Rooms> selectByName(String name, String otherName);
}
