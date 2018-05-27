package com.web.entity;

/**
 * 单元实体类，对应表zmkm.units
 * @author lijialong
 * */
public class Units extends Segments {
private String building_uuid;

public String getBuilding_uuid() {
	return building_uuid;
}

public void setBuilding_uuid(String building_uuid) {
	this.building_uuid = building_uuid;
}

}
