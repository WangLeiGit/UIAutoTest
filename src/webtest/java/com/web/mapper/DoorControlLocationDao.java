package com.web.mapper;

/**
 * 设备表接口
 * 
 * @author lijialong
 */
public interface DoorControlLocationDao {
	/**
	 * 根据location_uuid删除设备
	 * 
	 * @param uuid
	 *            设备所属分区||楼栋||单元||门牌ID
	 */
	public int deleteByLocationUuid(String location_uuid);
}
