package com.web.entity;

/**
 * 设备实体类，对应表zmkm.door_control_location
 * 
 * @author lijialong
 */
public class DoorControlLocation {
	private Integer id;
	private String uuid;
	private String door_control_uuid;
	private String door_control_unique;
	private Integer location_type;
	private String alias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDoor_control_uuid() {
		return door_control_uuid;
	}

	public void setDoor_control_uuid(String door_control_uuid) {
		this.door_control_uuid = door_control_uuid;
	}

	public String getDoor_control_unique() {
		return door_control_unique;
	}

	public void setDoor_control_unique(String door_control_unique) {
		this.door_control_unique = door_control_unique;
	}

	public Integer getLocation_type() {
		return location_type;
	}

	public void setLocation_type(Integer location_type) {
		this.location_type = location_type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
