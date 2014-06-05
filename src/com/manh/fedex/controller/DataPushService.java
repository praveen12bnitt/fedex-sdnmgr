package com.manh.fedex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manh.fedex.sdn.domain.AppInstance;
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
		c1.setShortName("hmdp");
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/app/{code}")
	public void createAppData(@PathVariable String code) {
		
		AppInstance app1 = new AppInstance();
		app1.setHost(code+"-test1."+code+".com");
		app1.setPort(20000);
		app1.setName("wm2013");
		app1.setProduct("WM");
		app1.setLocation("/apps/scope/wm");
		
		AppInstance app2 = new AppInstance();
		app2.setHost(code+"-test1."+code+".com");
		app2.setPort(20000);
		app2.setName("mda2013");
		app2.setProduct("MDA");
		app2.setLocation("/apps/scope/mda");
		
		AppInstance app3 = new AppInstance();
		app3.setHost(code+"-test1."+code+".com");
		app3.setPort(10000);
		app3.setName("mip2013");
		app3.setProduct("MIP");
		app3.setLocation("/apps/scope/mip");
		
		AppInstance app4 = new AppInstance();
		app4.setHost(code+"-prod1."+code+".com");
		app4.setPort(20000);
		app4.setName("wm2013");
		app4.setProduct("WM");
		app4.setLocation("/apps/scope/wm");
		
		AppInstance app5 = new AppInstance();
		app5.setHost(code+"-prod1."+code+".com");
		app5.setPort(20000);
		app5.setName("mda2013");
		app5.setProduct("MDA");
		app5.setLocation("/apps/scope/mda");
		
		AppInstance app6 = new AppInstance();
		app6.setHost(code+"-prod1."+code+".com");
		app6.setPort(10000);
		app6.setName("mip2013");
		app6.setProduct("MIP");
		app6.setLocation("/apps/scope/mip");
		
		List<AppInstance> apps = new ArrayList<AppInstance>();
		
		apps.add(app1);
		apps.add(app2);
		apps.add(app3);
		apps.add(app4);
		apps.add(app5);
		apps.add(app6);
		
		Customer customer = customerService.getCustomerByShortName(code);
		customer.setAppInstances(apps);
		
		customerService.save(customer);
		
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/appupd/{code}")
	public void setAppliedSDNs(@PathVariable String code) {
		
		List<String> asdns = new ArrayList<String>();
		asdns.add("fp001");
		asdns.add("fp002");
		asdns.add("fp003");
		asdns.add("fp004");
		
		List<String> psdns = new ArrayList<String>();
		psdns.add("fp005");
		psdns.add("fp006");
		psdns.add("fp007");
		
		AppInstance app1 = new AppInstance();
		app1.setHost(code+"-test1."+code+".com");
		app1.setPort(20000);
		app1.setName("wm2013");
		app1.setProduct("WM");
		app1.setLocation("/apps/scope/wm");
		app1.setAppliedSdns(asdns);
		app1.setPendingSdns(psdns);
		
		AppInstance app2 = new AppInstance();
		app2.setHost(code+"-test1."+code+".com");
		app2.setPort(20000);
		app2.setName("mda2013");
		app2.setProduct("MDA");
		app2.setLocation("/apps/scope/mda");
		app1.setAppliedSdns(psdns);
		app1.setPendingSdns(asdns);
		
		AppInstance app3 = new AppInstance();
		app3.setHost(code+"-test1."+code+".com");
		app3.setPort(10000);
		app3.setName("mip2013");
		app3.setProduct("MIP");
		app3.setLocation("/apps/scope/mip");
		
		AppInstance app4 = new AppInstance();
		app4.setHost(code+"-prod1."+code+".com");
		app4.setPort(20000);
		app4.setName("wm2013");
		app4.setProduct("WM");
		app4.setLocation("/apps/scope/wm");
		
		AppInstance app5 = new AppInstance();
		app5.setHost(code+"-prod1."+code+".com");
		app5.setPort(20000);
		app5.setName("mda2013");
		app5.setProduct("MDA");
		app5.setLocation("/apps/scope/mda");
		
		AppInstance app6 = new AppInstance();
		app6.setHost(code+"-prod1."+code+".com");
		app6.setPort(10000);
		app6.setName("mip2013");
		app6.setProduct("MIP");
		app6.setLocation("/apps/scope/mip");
		
		List<AppInstance> apps = new ArrayList<AppInstance>();
		
		apps.add(app1);
		apps.add(app2);
		apps.add(app3);
		apps.add(app4);
		apps.add(app5);
		apps.add(app6);
		
		Customer customer = customerService.getCustomerByShortName(code);
		customer.setAppInstances(apps);
		
		customerService.save(customer);	
		
	}
}
