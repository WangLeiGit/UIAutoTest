package com.appium.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.appium.entity.YlNcRelation;
import com.etyero.dao.SqlSessionUtil;
import com.appium.mapper.YlNcRelationDao;

/**
 * yl_nc_relation表操作类
 * 
 * @author lijialong
 */
public class YlNcRelationDaoImpl implements YlNcRelationDao {
	private SqlSessionUtil sessionUtil = null;
	private final static String Operation_object = "com.appium.mapper.YlNcRelationMapper";

	@Override
	public List<YlNcRelation> selectYlNcRelation(String docno, String user_id) {
		Map<Object, Object> params = new HashMap<>();
		sessionUtil = new SqlSessionUtil();
		params.put("docno", docno);
		params.put("user_id", user_id);
		List<YlNcRelation> ylNcRelations = sessionUtil.getSession()
				.selectList(Operation_object + ".selectYlNcRelations", params);
		sessionUtil.closeSession();
		return ylNcRelations;
	}

	@Override
	public int countYlNcRelation(String user_id) {
		sessionUtil = new SqlSessionUtil();
		int count = sessionUtil.getSession().selectOne(Operation_object + ".countYlNcRelation", user_id);
		sessionUtil.closeSession();
		return count;
	}

	// public static void main(String[] args) {
	// System.out.println(new
	// YlNcRelationDaoImpl().countYlNcRelation("c5404254-3b79-48a1-a0f1-c789aab9eda9"));
	// }
}
