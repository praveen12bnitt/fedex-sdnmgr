package com.manh.fedex.sdn.domain;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
	@Id
	private String id;
	private String name;
	private String shortName; 	
	private String logo;
	private Contact contact;
	private List<AppInstance> appInstances;
	private boolean pendingCount;
	
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public List<AppInstance> getAppInstances() {
		return appInstances;
	}
	public void setAppInstances(List<AppInstance> appInstances) {
		this.appInstances = appInstances;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public boolean getPendingCount() {
		this.pendingCount = false;
		List<AppInstance> appInsts = this.getAppInstances();
		for (Iterator<AppInstance> iterator = appInsts.iterator(); iterator.hasNext();) {
			AppInstance appInstance = (AppInstance) iterator.next();
			
			if(appInstance.getPendingSdns() != null && appInstance.getPendingSdns().size() > 0) {
				this.pendingCount = true;
			}
		}
		
		return this.pendingCount;
	}
	public void setPendingCount(boolean pendingCount) {
		this.pendingCount = pendingCount;
	}
}
