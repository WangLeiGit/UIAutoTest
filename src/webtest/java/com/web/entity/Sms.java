package com.web.entity;

/**
 * 短信记录实体类，对应表db_sms.hgy_sms_history
 * 
 * @author lijialong
 */
public class Sms {
	private int id;
	private String smscode;// 短信编号
	private String content;// 短信内容
	private String requestip;// 请求发送短信的IP地址
	private int bizid;// 业务系统id
	private long createtime;// 创建时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSmscode() {
		return smscode;
	}

	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRequestip() {
		return requestip;
	}

	public void setRequestip(String requestip) {
		this.requestip = requestip;
	}

	public int getBizid() {
		return bizid;
	}

	public void setBizid(int bizid) {
		this.bizid = bizid;
	}

	public long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}

}
