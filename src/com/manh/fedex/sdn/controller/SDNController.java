package com.manh.fedex.sdn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Customer;
import com.manh.fedex.sdn.domain.SDN;
import com.manh.fedex.sdn.service.CustomerService;
import com.manh.fedex.sdn.service.SDNService;


@RestController
@RequestMapping("/sdn")
public class SDNController {
	
	@Autowired
	private CustomerService custServ;
	
	@Autowired
	private SDNService sdnServ;
	
	@RequestMapping(method = RequestMethod.GET)
	public SDN getSDN(String sdnId) {
		return sdnServ.getSDN(sdnId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listCustomers")
	public List<Customer> listCustomers() {
		return custServ.listCustomers();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listSdnsForCustomer")
	public List<SDN> listSDNsForCustomer(String custId) {
		return custServ.listSDNsForCustomer(custId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listAppInstancesForCust")
	public List<AppInstance> listAppInstancesForCust(String custId) {
		return custServ.listAppInstancesForCust(custId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listAppliedAppInstancesForCust")
	public List<AppInstance> listAppliedAppInstancesForCust(String custId) {
		return custServ.listAppliedAppInstancesForCust(custId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listPendingAppInstancesForCust")
	public List<AppInstance> listPendingAppInstancesForCust(String custId) {
		return custServ.listPendingAppInstancesForCust(custId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listSDNsForCustAppInst")
	public List<SDN> listSDNsForCustAppInst(String custId, String appName) {
		return custServ.listSDNsForCustAppInst(custId, appName);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCustomerByShortName")
	public Customer getCustomerByShortName(String shortName) {
		return custServ.getCustomerByShortName(shortName);
	}

}
