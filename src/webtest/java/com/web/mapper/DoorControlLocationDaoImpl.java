package com.web.mapper;

import com.etyero.dao.SqlSessionUtil;

/**
 * door_control_location表操作类
 * 
 * @author lijialong
 */
public class DoorControlLocationDaoImpl implements DoorControlLocationDao {
	private SqlSessionUtil sessionUtil = null;
	private final static String Operation_object = "com.web.mapper.DoorControlLocationMapper";


	@Override
	public int deleteByLocationUuid(String location_uuid) {
		sessionUtil = new SqlSessionUtil();
		int num = sessionUtil.getSession().delete(Operation_object + ".deleteDoorControlLocation", location_uuid);
		sessionUtil.commit();
		sessionUtil.closeSession();
		return num;
	}
    public static void main(String[] args) {
		new DoorControlLocationDaoImpl().deleteByLocationUuid("412f865c-0c8d-4ed8-bbf0-c7252325aaf0");
	}
}
