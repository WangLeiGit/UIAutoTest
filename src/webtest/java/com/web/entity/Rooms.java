package com.web.entity;

/**
 * 门牌号实体类，对应表zmkm.rooms
 * @author lijialong
 * */
public class Rooms extends Segments{
private String unit_uuid;

public String getUnit_uuid() {
	return unit_uuid;
}

public void setUnit_uuid(String unit_uuid) {
	this.unit_uuid = unit_uuid;
}
}
