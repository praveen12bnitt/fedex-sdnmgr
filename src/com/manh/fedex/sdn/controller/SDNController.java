package com.manh.fedex.sdn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
