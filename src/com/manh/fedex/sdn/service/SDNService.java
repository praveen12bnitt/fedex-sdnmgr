package com.manh.fedex.sdn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Customer;
import com.manh.fedex.sdn.domain.SDN;

@Service
public class SDNService {
	@Autowired
	private MongoOperations mongoOperation;
	
	@Autowired
	private CustomerService customerService;
		
	public SDN getSDN(String sdnId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(sdnId));
		SDN sdn = mongoOperation.findOne(query, SDN.class);
		return sdn;
	}
	
	public void createSdn(SDN sdn, Customer customer) { 		
		mongoOperation.save(sdn); 		
		for(AppInstance app : customer.getAppInstances()) {
			if(app.getProduct().equals(sdn.getProductName())) {
				app.getPendingSdns().add(sdn.getId());
			}
		}  		
		mongoOperation.save(customer); 		
	}
	
	public void markSdnApplied(String custCode, String appName, String sdnName) {
		Customer customer = customerService.getCustomerByShortName(custCode);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(sdnName));
		SDN sdn = mongoOperation.findOne(query, SDN.class);
		
		AppInstance selectedAppInstance = null;
		for(AppInstance app : customer.getAppInstances()) {
			
			if(app.getName().equals(appName)) {
				selectedAppInstance = app;
				break;
			} 			
			
		}  			
		if(selectedAppInstance != null) {
			if(selectedAppInstance.getPendingSdns().contains(sdn.getId())) {
				selectedAppInstance.getAppliedSdns().add(sdn.getId());
				selectedAppInstance.getPendingSdns().remove(sdn.getId());
			}
		}
		
		mongoOperation.save(customer); 	
		
	}
}
