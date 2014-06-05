package com.manh.fedex.sdn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Customer;
import com.manh.fedex.sdn.service.CustomerService;

@RestController
@RequestMapping("/sync")
public class SyncService {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void syncApps(@RequestParam String customerCode, @RequestBody List<AppInstance> newApps) {

		// Get the customer 
		Customer customer = customerService.getCustomerByShortName(customerCode);
				
		for(AppInstance app : newApps) {
			AppInstance match = fineMatch(customer, app);
			if(match != null) {
				app.setAppliedSdns(match.getAppliedSdns());
				app.setPendingSdns(match.getPendingSdns());
			} 	
		} 		
		customer.setAppInstances(newApps); 		
		customerService.save(customer);
				
	}

	private AppInstance fineMatch(Customer customer, AppInstance app) {
		for(AppInstance appInstance : customer.getAppInstances()) {
			if(appInstance.getHost().equals(app.getHost()) && appInstance.getLocation().equals(app.getLocation())) return appInstance;
		}
		return null;
	}

	
}
