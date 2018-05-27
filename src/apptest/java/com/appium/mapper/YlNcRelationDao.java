package com.appium.mapper;

import java.util.List;

import com.appium.entity.YlNcRelation;

/**
 * 物业缴费订单表接口
 * 
 * @author lijialong
 */
public interface YlNcRelationDao {

	/**
	 * 根据订单号||user_id查询
	 * 
	 * @param docno
	 *            订单号
	 * @param user_id
	 *            用户id
	 * @return
	 */
	public List<YlNcRelation> selectYlNcRelation(String docno, String user_id);

	/**
	 * 根据user_id统计查询结果
	 * 
	 * @param user_id
	 *            用户id
	 * @return
	 */
	public int countYlNcRelation(String user_id);
}
