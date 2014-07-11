package com.manh.fedex.sdn.domain;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sdns")
public class SDN {
	@Id
	private String id;
	private String name;
	private Object binaryId;
	private Date publishDate;
	private String custId;
	private String productName;
	private String desc;
	
	@Transient
	private List<String> appliedApps;
	
	@Transient
	private List<String> pendingApps;
	
	@Transient
	private boolean applied = false;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getBinaryId() {
		return binaryId;
	}
	public void setBinaryId(Object binaryId) {
		this.binaryId = binaryId;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public boolean isApplied() {
		return applied;
	}
	public void setApplied(boolean applied) {
		this.applied = applied;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<String> getAppliedApps() {
		return appliedApps;
	}
	public void setAppliedApps(List<String> appliedApps) {
		this.appliedApps = appliedApps;
	}
	public List<String> getPendingApps() {
		return pendingApps;
	}
	public void setPendingApps(List<String> pendingApps) {
		this.pendingApps = pendingApps;
	}
}
