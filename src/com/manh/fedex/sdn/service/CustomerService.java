package com.manh.fedex.sdn.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Customer;
import com.manh.fedex.sdn.domain.SDN;

@Service
public class CustomerService {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private SDNService sdnService = SDNService.getInstance();
	
	public List<Customer> listCustomers() {
		return mongoOperation.findAll(Customer.class);
	}

	public List<SDN> listSDNsForCustomer(String custId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("custId").is(custId));
		return mongoOperation.find(query, SDN.class);
	}
	
	public List<AppInstance> listAppInstancesForCust(String custId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(custId));
		List<Customer> custs = mongoOperation.find(query, Customer.class);
		if(custs.size() > 0) {
			return custs.get(0).getAppInstances();
		} else {
			return new ArrayList<AppInstance>();
		}
	}
	
	public List<AppInstance> listAppliedAppInstancesForCust(String custId) {
		Query query = new Query();
		List<AppInstance> apps = new ArrayList<AppInstance>();
		List<AppInstance> appliedApps = new ArrayList<AppInstance>();
		query.addCriteria(Criteria.where("id").is(custId));
		List<Customer> custs = mongoOperation.find(query, Customer.class);
		if(custs.size() > 0) {
			apps = custs.get(0).getAppInstances();
		} else {
			apps = new ArrayList<AppInstance>();
		}
		
		for (Iterator<AppInstance> iterator = apps.iterator(); iterator.hasNext();) {
			AppInstance appInst = (AppInstance) iterator.next();
			if(appInst.getAppliedSdns() != null && appInst.getAppliedSdns().size() > 0 && appInst.getPendingSdns().size() == 0) {
				appliedApps.add(appInst);
			}			
		}
		
		return appliedApps;
	}
	
	public List<AppInstance> listPendingAppInstancesForCust(String custId) {
		Query query = new Query();
		List<AppInstance> apps = new ArrayList<AppInstance>();
		List<AppInstance> pendingApps = new ArrayList<AppInstance>();
		query.addCriteria(Criteria.where("id").is(custId));
		List<Customer> custs = mongoOperation.find(query, Customer.class);
		if(custs.size() > 0) {
			apps = custs.get(0).getAppInstances();
		} else {
			apps = new ArrayList<AppInstance>();
		}
		
		for (Iterator<AppInstance> iterator = apps.iterator(); iterator.hasNext();) {
			AppInstance appInst = (AppInstance) iterator.next();
			if(appInst.getPendingSdns() != null && appInst.getPendingSdns().size() > 0) {
				pendingApps.add(appInst);
			}
		}
		
		return pendingApps;
	}
	
	public List<SDN> listSDNsForCustAppInst(String custId, String appName) {
		Query query = new Query();
		List<AppInstance> apps = new ArrayList<AppInstance>();
		List<SDN> sdns = new ArrayList<SDN>();
		
		
		query.addCriteria(Criteria.where("custId").is(custId));
		List<Customer> custs = mongoOperation.find(query, Customer.class);
		if(custs.size() > 0) {
			apps = custs.get(0).getAppInstances();
		} else {
			apps = new ArrayList<AppInstance>();
		}
		
		for (Iterator<AppInstance> iterator = apps.iterator(); iterator.hasNext();) {
			AppInstance appInst = (AppInstance) iterator.next();
			List<String> appliedSdnIds = appInst.getAppliedSdns();
			List<String> pendingSdnIds = appInst.getPendingSdns();
			for (String id : appliedSdnIds) {
				sdns.add(sdnService.getSDN(id));
			}
			
			for (String id : pendingSdnIds) {
				sdns.add(sdnService.getSDN(id));
			}
		}
		
		return sdns;
	}

	public Customer getCustomerByShortName(String shortName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("shortName").is(shortName));
		List<Customer> custList =  mongoOperation.find(query, Customer.class);
		
		if(custList.size() > 0) {
			return custList.get(0);
		}
		return null;
	}
	
	public void save(Customer customer) {
		mongoOperation.save(customer);
	}
}
