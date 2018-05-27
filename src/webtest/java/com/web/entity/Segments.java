package com.web.entity;

/**
 * 分区实体类，对应表zmkm.segments
 * 
 * @author lijialong
 */
public class Segments {
	private Integer id;// id
	private String uuid;// 分区id
	private String community_uuid;// 社区id
	private String name;// 名称
	private String alias;// 别名
	private int door_control;// 门禁，0无1有
    
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

	public String getCommunity_uuid() {
		return community_uuid;
	}

	public void setCommunity_uuid(String community_uuid) {
		this.community_uuid = community_uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getDoor_control() {
		return door_control;
	}

	public void setDoor_control(int door_control) {
		this.door_control = door_control;
	}
}
