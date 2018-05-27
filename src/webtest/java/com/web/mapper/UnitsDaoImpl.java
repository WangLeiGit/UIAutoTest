package com.web.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etyero.dao.SqlSessionUtil;
import com.web.entity.Units;

/**
 * units表操作类
 * 
 * @author lijialong
 */
public class UnitsDaoImpl implements UnitsDao {
	private SqlSessionUtil sessionUtil = null;
	private final static String Operation_object = "com.web.mapper.UnitsMapper";

	@Override
	public int deleteByName(String name) {
		sessionUtil = new SqlSessionUtil();
		int num = sessionUtil.getSession().delete(Operation_object + ".deleteUnits", name);
		sessionUtil.commit();
		sessionUtil.closeSession();
		return num;
	}

	@Override
	public List<Units> selectByName(String name, String otherName) {
		Map<Object, Object> params = new HashMap<>();
		sessionUtil = new SqlSessionUtil();
		params.put("name", name);
		params.put("alias", otherName);
		List<Units> units = sessionUtil.getSession().selectList(Operation_object + ".selectUnits", params);
		sessionUtil.closeSession();
		return units;
	}
	
//	public static void main(String[] args) {
//		String[] itemName={"分区测试","分区测试-楼栋","分区测试-楼栋-单元","分区测试-楼栋-单元-门牌号"};
//		// 清理分区及分区设备数据
//		SegmentsDao sDao = new SegmentsDaoImpl();
//		String location_uuid = sDao.selectByName(itemName[0], "").get(0).getUuid();
//		sDao.deleteByName(itemName[0]);
//		DoorControlLocationDao dLocationDao = new DoorControlLocationDaoImpl();
//		dLocationDao.deleteByLocationUuid(location_uuid);
//		// 清理楼栋及楼栋设备数据
//		BuildingsDao bDao = new BuildingsDaoImpl();
//		location_uuid = bDao.selectByName(itemName[1], "").get(0).getUuid();
//		bDao.deleteByName(itemName[1]);
//		dLocationDao.deleteByLocationUuid(location_uuid);
//		// 清理单元及单元设备数据
//		UnitsDao uDao = new UnitsDaoImpl();
//		location_uuid = uDao.selectByName(itemName[2], "").get(0).getUuid();
//		uDao.deleteByName(itemName[2]);
//		dLocationDao.deleteByLocationUuid(location_uuid);
//		// 清理门牌数据
//		RoomsDao rDao = new RoomsDaoImpl();
//		rDao.deleteByName(itemName[3]);
//	}
}
