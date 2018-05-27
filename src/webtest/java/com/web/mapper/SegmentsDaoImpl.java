package com.web.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etyero.dao.SqlSessionUtil;
import com.web.entity.Segments;

/**
 * segments表操作类
 * 
 * @author lijialong
 */
public class SegmentsDaoImpl implements SegmentsDao {
	private SqlSessionUtil sessionUtil = null;
	private final static String Operation_object = "com.web.mapper.SegmentsMapper";

	@Override
	public List<Segments> selectByName(String name, String otherName) {
		Map<Object, Object> params = new HashMap<Object, Object>();
		sessionUtil = new SqlSessionUtil();
		params.put("name", name);
		params.put("alias", otherName);
		List<Segments> segments = sessionUtil.getSession().selectList(Operation_object + ".getSegments", params);
		sessionUtil.closeSession();
		return segments;
	}

	@Override
	public int deleteByName(String name) {
		sessionUtil = new SqlSessionUtil();
		int num = sessionUtil.getSession().delete(Operation_object + ".deleteSegments", name);
		sessionUtil.commit();
		sessionUtil.closeSession();
		return num;
	}

	public static void main(String[] args) {
		SegmentsDao sDao = new SegmentsDaoImpl();
		String location_uuid = sDao.selectByName("分区测试", "分区测试别名").get(0).getUuid();
		sDao.deleteByName("分区测试");
		System.out.println(location_uuid);
	}
}
