package com.manh.fedex.sdn.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Customer;
import com.manh.fedex.sdn.domain.SDN;


@RestController
@RequestMapping("/sdn")
public class SDNController {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	@RequestMapping(method = RequestMethod.POST)
	public SDN createSDN(@RequestBody SDN sdn) {
		mongoOperation.save(sdn);

		return sdn;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public SDN getSDN(String sdnId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(sdnId));
		return mongoOperation.findOne(query, SDN.class);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listCustomers")
	public List<Customer> listCustomers() {
		return mongoOperation.findAll(Customer.class);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listSdnsForCustomer")
	public List<SDN> listSDNsForCustomer(String custId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("custId").is(custId));
		return mongoOperation.find(query, SDN.class);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listAppInstancesForCust")
	public List<AppInstance> listAppInstancesForCust(String custId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("custId").is(custId));
		List<Customer> custs = mongoOperation.find(query, Customer.class);
		if(custs.size() > 0) {
			return custs.get(0).getAppInstances();
		} else {
			return new ArrayList<AppInstance>();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listAppliedAppInstancesForCust")
	public List<AppInstance> listAppliedAppInstancesForCust(String custId) {
		Query query = new Query();
		List<AppInstance> apps = new ArrayList<AppInstance>();
		List<AppInstance> appliedApps = new ArrayList<AppInstance>();
		query.addCriteria(Criteria.where("custId").is(custId));
		List<Customer> custs = mongoOperation.find(query, Customer.class);
		if(custs.size() > 0) {
			apps = custs.get(0).getAppInstances();
		} else {
			apps = new ArrayList<AppInstance>();
		}
		
		for (Iterator<AppInstance> iterator = apps.iterator(); iterator.hasNext();) {
			AppInstance appInst = (AppInstance) iterator.next();
			if(appInst.getAppliedSdns().size() > 0 && appInst.getPendingSdns().size() == 0) {
				appliedApps.add(appInst);
			}			
		}
		
		return appliedApps;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listPendingAppInstancesForCust")
	public List<AppInstance> listPendingAppInstancesForCust(String custId) {
		Query query = new Query();
		List<AppInstance> apps = new ArrayList<AppInstance>();
		List<AppInstance> pendingApps = new ArrayList<AppInstance>();
		query.addCriteria(Criteria.where("custId").is(custId));
		List<Customer> custs = mongoOperation.find(query, Customer.class);
		if(custs.size() > 0) {
			apps = custs.get(0).getAppInstances();
		} else {
			apps = new ArrayList<AppInstance>();
		}
		
		for (Iterator<AppInstance> iterator = apps.iterator(); iterator.hasNext();) {
			AppInstance appInst = (AppInstance) iterator.next();
			if(appInst.getPendingSdns().size() > 0) {
				pendingApps.add(appInst);
			}
		}
		
		return pendingApps;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listSDNsForCustAppInst")
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
				sdns.add(getSDN(id));
			}
			
			for (String id : pendingSdnIds) {
				sdns.add(getSDN(id));
			}
		}
		
		return sdns;
	}

}
