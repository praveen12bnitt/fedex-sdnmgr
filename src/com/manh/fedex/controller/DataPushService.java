package com.manh.fedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manh.fedex.sdn.domain.Contact;
import com.manh.fedex.sdn.domain.Customer;
import com.manh.fedex.sdn.service.CustomerService;

@RestController
@RequestMapping("/pushData")
public class DataPushService {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cust")
	public void createCustData() {
		
		Customer c1 = new Customer();
		c1.setName("Home Depot");
		c1.setShortName("hdmp");
		c1.setLogo("/logo/homedepot.jpg");
		
		
		Contact contact1 = new Contact();
		contact1.setPrimaryEmail("prajan@hmdp.com");
		contact1.setSecondaryEmail("prajan1@hmdp.com");
		contact1.setPrimaryPhone("404 509 7085");
		contact1.setSecondaryPhone("404 509 7085");
		contact1.setPreference("email");
		
		c1.setContact(contact1);
		
		customerService.save(c1);
		
		Customer c2 = new Customer();
		c2.setName("Macys");
		c2.setShortName("macys");
		c2.setLogo("/logo/macys.jpg"); 	
		
		Contact contact2 = new Contact();
		contact2.setPrimaryEmail("prajan@macys.com");
		contact2.setSecondaryEmail("prajan1@macys.com");
		contact2.setPrimaryPhone("404 509 7085");
		contact2.setSecondaryPhone("404 509 7085");
		contact2.setPreference("email");
		
		c2.setContact(contact2);
		
		customerService.save(c2);
		
		
		Customer c3 = new Customer();
		c3.setName("Target");
		c3.setShortName("target");
		c3.setLogo("/logo/target.jpg"); 	
		
		Contact contact3 = new Contact();
		contact3.setPrimaryEmail("prajan@target.com");
		contact3.setSecondaryEmail("prajan1@target.com");
		contact3.setPrimaryPhone("404 509 7085");
		contact3.setSecondaryPhone("404 509 7085");
		contact3.setPreference("email");
		
		c3.setContact(contact3);
		
		customerService.save(c3);
		
		Customer c4 = new Customer();
		c4.setName("Mens Warehouse");
		c4.setShortName("mw");
		c4.setLogo("/logo/mw.jpg"); 	
		
		Contact contact4 = new Contact();
		contact4.setPrimaryEmail("prajan@mw.com");
		contact4.setSecondaryEmail("prajan1@mw.com");
		contact4.setPrimaryPhone("404 509 7085");
		contact4.setSecondaryPhone("404 509 7085");
		contact4.setPreference("email");
		
		c4.setContact(contact4);
		
		customerService.save(c4);
		
		
	}
}
