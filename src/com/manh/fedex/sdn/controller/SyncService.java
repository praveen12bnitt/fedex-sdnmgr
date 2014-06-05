package com.manh.fedex.sdn.controller;

import java.util.List;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Customer;

public class SyncService {

	
	
	public void syncApps(String customerCode, List<AppInstance> newApps) {

		// Get the customer

		Customer customer = null;
		
		
		for(AppInstance app : newApps) {
			AppInstance match = fineMatch(customer, app);
			if(match != null) {
				app.setAppliedSdns(match.getAppliedSdns());
				app.setPendingSdns(match.getPendingSdns());
			} 	
		}
		
		customer.setAppInstances(newApps);
		
		
		
		
	}

	private AppInstance fineMatch(Customer customer, AppInstance app) {
		for(AppInstance appInstance : customer.getAppInstances()) {
			if(appInstance.getHost().equals(app.getHost()) && appInstance.getLocation().equals(app.getLocation())) return appInstance;
		}
		return null;
	}

	
}
