package com.appium.entity;

import java.sql.Date;

/**
 * 物业缴费订单实体类，对应表zmkm.yl_nc_relation
 * 
 * @author lijialong
 */
public class YlNcRelation {
	private String nc_house_name;
	private String community_uuid;
	private String segment_uuid;
	private String building_uuid;
	private String unit_uuid;
	private String room_uuid;
	private String user_id;
	private String docno;// 订单号
	private Double doc_reamt;// 应缴金额
	private Double doc_netamt;// 实收金额
	private Date doc_dt;// 订单创建时间
	private Integer doc_state;// 订单状态

	public String getNc_house_name() {
		return nc_house_name;
	}

	public void setNc_house_name(String nc_house_name) {
		this.nc_house_name = nc_house_name;
	}

	public String getCommunity_uuid() {
		return community_uuid;
	}

	public void setCommunity_uuid(String community_uuid) {
		this.community_uuid = community_uuid;
	}

	public String getSegment_uuid() {
		return segment_uuid;
	}

	public void setSegment_uuid(String segment_uuid) {
		this.segment_uuid = segment_uuid;
	}

	public String getBuilding_uuid() {
		return building_uuid;
	}

	public void setBuilding_uuid(String building_uuid) {
		this.building_uuid = building_uuid;
	}

	public String getUnit_uuid() {
		return unit_uuid;
	}

	public void setUnit_uuid(String unit_uuid) {
		this.unit_uuid = unit_uuid;
	}

	public String getRoom_uuid() {
		return room_uuid;
	}

	public void setRoom_uuid(String room_uuid) {
		this.room_uuid = room_uuid;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDocno() {
		return docno;
	}

	public void setDocno(String docno) {
		this.docno = docno;
	}

	public Double getDoc_reamt() {
		return doc_reamt;
	}

	public void setDoc_reamt(Double doc_reamt) {
		this.doc_reamt = doc_reamt;
	}

	public Double getDoc_netamt() {
		return doc_netamt;
	}

	public void setDoc_netamt(Double doc_netamt) {
		this.doc_netamt = doc_netamt;
	}

	public Date getDoc_dt() {
		return doc_dt;
	}

	public void setDoc_dt(Date doc_dt) {
		this.doc_dt = doc_dt;
	}

	public Integer getDoc_state() {
		return doc_state;
	}

	public void setDoc_state(Integer doc_state) {
		this.doc_state = doc_state;
	}

}
