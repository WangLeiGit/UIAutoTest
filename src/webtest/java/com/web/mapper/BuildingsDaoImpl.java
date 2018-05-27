package com.web.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etyero.dao.SqlSessionUtil;
import com.web.entity.Buildings;

/**
 * buildings表操作类
 * 
 * @author lijialong
 */
public class BuildingsDaoImpl implements BuildingsDao {
	private SqlSessionUtil sessionUtil = null;
	private final static String Operation_object = "com.web.mapper.BuildingsMapper";

	@Override
	public int deleteByName(String name) {
		sessionUtil = new SqlSessionUtil();
		int num = sessionUtil.getSession().delete(Operation_object + ".deleteBuildings", name);
		sessionUtil.commit();
		sessionUtil.closeSession();
		return num;
	}

	@Override
	public List<Buildings> selectByName(String name, String otherName) {
		Map<Object, Object> params = new HashMap<>();
		sessionUtil = new SqlSessionUtil();
		params.put("name", name);
		params.put("alias", otherName);
		List<Buildings> buildings = sessionUtil.getSession().selectList(Operation_object + ".selectBuildings", params);
		sessionUtil.closeSession();
		return buildings;
	}

}
