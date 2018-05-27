package com.web.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etyero.dao.SqlSessionUtil;
import com.web.entity.Rooms;

/**
 * rooms表操作类
 * 
 * @author lijialong
 */
public class RoomsDaoImpl implements RoomsDao {
	private SqlSessionUtil sessionUtil = null;
	private final static String Operation_object = "com.web.mapper.RoomsMapper";

	@Override
	public int deleteByName(String name) {
		sessionUtil = new SqlSessionUtil();
		int num = sessionUtil.getSession().delete(Operation_object + ".deleteRooms", name);
		sessionUtil.commit();
		sessionUtil.closeSession();
		return num;
	}

	@Override
	public List<Rooms> selectByName(String name, String otherName) {
		Map<Object, Object> params = new HashMap<>();
		sessionUtil = new SqlSessionUtil();
		params.put("name", name);
		params.put("alias", otherName);
		List<Rooms> rooms = sessionUtil.getSession().selectList(Operation_object + ".selectRooms", params);
		sessionUtil.closeSession();
		return rooms;
	}
}
