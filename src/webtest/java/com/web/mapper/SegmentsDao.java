package com.web.mapper;

import java.util.List;

import com.web.entity.Segments;

/**
 * 分区表接口
 * 
 * @author lijialong
 */
public interface SegmentsDao {
	/**
	 * 根据分区名称/别名查询
	 * 
	 * @param name
	 *            分区名
	 * @param otherName
	 *            分区别名
	 * @return
	 */
	public List<Segments> selectByName(String name, String otherName);

	/**
	 * 根据分区名称删除分区
	 * 
	 * @param name
	 *            分区名称
	 * @return
	 */
	public int deleteByName(String name);
}
