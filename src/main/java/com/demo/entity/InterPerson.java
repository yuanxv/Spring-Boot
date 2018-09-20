package com.demo.entity;

public class InterPerson {

//	W3账号
	private String w3Count;
//	名称账号
	private String nameCount;
//	负责工具Id
	private String appId;
//	头像文件名称
	private String imgName;
//	上次更新时间
	private Long lastUpdateTime;
	public String getW3Count() {
		return w3Count;
	}
	public void setW3Count(String w3Count) {
		this.w3Count = w3Count;
	}
	public String getNameCount() {
		return nameCount;
	}
	public void setNameCount(String nameCount) {
		this.nameCount = nameCount;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public Long getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	

}
