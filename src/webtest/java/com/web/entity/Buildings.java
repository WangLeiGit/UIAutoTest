package com.web.entity;

/**
 * 楼栋实体类 对应表zmkm.buildings
 * 
 * @author lijialong
 */
public class Buildings extends Segments {
	private String segment_uuid;

	public String getSegment_uuid() {
		return segment_uuid;
	}

	public void setSegment_uuid(String segment_uuid) {
		this.segment_uuid = segment_uuid;
	}
	
}
