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
	
	@Autowired
	private SDNService sdnService;
	
	public List<Customer> listCustomers() {
		return mongoOperation.findAll(Customer.class);
	}

	public List<SDN> listSDNsForCustomer(String custId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("custId").is(custId));
		List<AppInstance> appInsts = new ArrayList<AppInstance>();
		List<SDN> sdns = new ArrayList<SDN>();
		List<SDN> retSdns = new ArrayList<SDN>();
		
		sdns = mongoOperation.find(query, SDN.class);
		
		query = new Query();
		query.addCriteria(Criteria.where("id").is(custId));
		List<Customer> custs = mongoOperation.find(query, Customer.class);
		if(custs.size() > 0) {
			appInsts = custs.get(0).getAppInstances();
		}
		
		
		
		for (SDN sdn : sdns) {
			List<String> appliedAppStrList = new ArrayList<String>();
			List<String> pendingAppStrList = new ArrayList<String>();
			
			for (AppInstance appInst : appInsts) {
				List<String> appliedSDNs = appInst.getAppliedSdns();
				for (String sdnStr : appliedSDNs) {
					if(sdnStr.equals(sdn.getId())){
						appliedAppStrList.add(appInst.getHost() + ":" + appInst.getPort() + " - " + appInst.getName());
					}
				}
			}
			
			for (AppInstance appInst : appInsts) {
				List<String> pendingSDNs = appInst.getPendingSdns();
				for (String sdnStr : pendingSDNs) {
					if(sdnStr.equals(sdn.getId())){
						pendingAppStrList.add(appInst.getHost() + ":" + appInst.getPort() + " - " + appInst.getName());
					}
				}
			}
			
			sdn.setAppliedApps(appliedAppStrList);
			sdn.setPendingApps(pendingAppStrList);
			retSdns.add(sdn);
		}
		
		return retSdns;
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
	
	public List<SDN> listSDNsForCustAppInst(String custShortName, String appName) {
		Query query = new Query(); 		
		List<SDN> sdns = new ArrayList<SDN>();
		query.addCriteria(Criteria.where("shortName").is(custShortName));
		
		Customer custs = mongoOperation.findOne(query, Customer.class);
		AppInstance app = null;
		for(AppInstance a : custs.getAppInstances()) {
			if(a.getName().equals(appName))  {
				app = a;
				break;
			}
		}
		
		if(app != null) {
			for (String id : app.getAppliedSdns()) {
				SDN sdn = sdnService.getSDN(id);
				sdn.setApplied(true);
				sdns.add(sdn);
			}
			
			for (String id : app.getPendingSdns()) {
				SDN sdn = sdnService.getSDN(id);
				sdns.add(sdn);
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
