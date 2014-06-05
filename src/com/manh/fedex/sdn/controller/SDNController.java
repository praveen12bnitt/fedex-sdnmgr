package com.manh.fedex.sdn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manh.fedex.sdn.domain.Customer;
import com.manh.fedex.sdn.domain.SDN;
import com.manh.fedex.sdn.repo.CustomerRepository;
import com.manh.fedex.sdn.repo.SDNRepository;


@RestController
@RequestMapping("/sdn")
public class SDNController {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SDNRepository sdnRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public SDN createSDN(@RequestBody SDN sdn) {
		mongoOperation.save(sdn);

		return sdn;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listCustomers")
	public List<Customer> listCustomers() {

		return customerRepository.findAll();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/listSdns")
	public List<SDN> listSDNs(String custId) {
		
		return sdnRepository.findAllByCustomerId(custId);		

	}

}
