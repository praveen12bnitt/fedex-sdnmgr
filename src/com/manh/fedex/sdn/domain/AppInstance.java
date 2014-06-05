package com.manh.fedex.sdn.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appinsts")
public class AppInstance {
	@Id
	private String id;
	private String name;
	private String location;
	private String host;
	private int port;
	private String type;
	private List<String> appliedSdns;
	private List<String> pendingSdns;
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getAppliedSdns() {
		return appliedSdns;
	}
	public void setAppliedSdns(List<String> appliedSdns) {
		this.appliedSdns = appliedSdns;
	}
	public List<String> getPendingSdns() {
		return pendingSdns;
	}
	public void setPendingSdns(List<String> pendingSdns) {
		this.pendingSdns = pendingSdns;
	}
	
	
	
	
	
}
