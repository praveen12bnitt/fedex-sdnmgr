package com.manh.fedex.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Contact;
import com.manh.fedex.sdn.domain.Customer;
import com.manh.fedex.sdn.domain.SDN;
import com.manh.fedex.sdn.service.CustomerService;
import com.manh.fedex.sdn.service.SDNService;

@RestController
@RequestMapping("/pushData")
public class DataPushService {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SDNService sdnService;

	@RequestMapping(method = RequestMethod.GET, value = "/cust")
	public void createCustData() {

		Customer c1 = new Customer();
		c1.setName("Home Depot");
		c1.setShortName("hmdp");
		c1.setLogo("homedepot.jpg");

		Contact contact1 = new Contact();
		contact1.setPrimaryName("Palanivelrajan");
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
		c2.setLogo("macy.jpg");

		Contact contact2 = new Contact();
		contact2.setPrimaryName("Kaveen Balaji");
		contact2.setPrimaryEmail("kbalaji@macys.com");
		contact2.setSecondaryEmail("kbalaji@macys.com");
		contact2.setPrimaryPhone("404 509 7085");
		contact2.setSecondaryPhone("404 509 7085");
		contact2.setPreference("email");

		c2.setContact(contact2);

		customerService.save(c2);

		Customer c3 = new Customer();
		c3.setName("Target");
		c3.setShortName("target");
		c3.setLogo("target.jpg");

		Contact contact3 = new Contact();
		contact3.setPrimaryName("Sriram");
		contact3.setPrimaryEmail("sriram@target.com");
		contact3.setSecondaryEmail("sriram@target.com");
		contact3.setPrimaryPhone("404 509 7085");
		contact3.setSecondaryPhone("404 509 7085");
		contact3.setPreference("email");

		c3.setContact(contact3);

		customerService.save(c3);

		Customer c4 = new Customer();
		c4.setName("Mens Warehouse");
		c4.setShortName("mw");
		c4.setLogo("mens.jpg");

		Contact contact4 = new Contact();
		contact4.setPrimaryName("Kartik Pandya");
		contact4.setPrimaryEmail("kpandya@mw.com");
		contact4.setSecondaryEmail("prajan1@mw.com");
		contact4.setPrimaryPhone("404 509 7085");
		contact4.setSecondaryPhone("404 509 7085");
		contact4.setPreference("email");
		c4.setContact(contact4);
		customerService.save(c4);

		Customer c5 = new Customer();
		c5.setName("Puma");
		c5.setShortName("puma");
		c5.setLogo("puma.jpg");

		Contact contact5 = new Contact();
		contact5.setPrimaryName("Kartik Pandya");
		contact5.setPrimaryEmail("kpandya@mw.com");
		contact5.setSecondaryEmail("prajan1@mw.com");
		contact5.setPrimaryPhone("404 509 7085");
		contact5.setSecondaryPhone("404 509 7085");
		contact5.setPreference("email");
		c5.setContact(contact5);
		customerService.save(c5);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/app/")
	public void createAppData() {

		// Macys
		String code = "macys";
		AppInstance app1 = new AppInstance();
		app1.setHost(code + "-test1." + code + ".com");
		app1.setPort(20000);
		app1.setName("wm2013-test");
		app1.setProduct("WM");
		app1.setLocation("/apps/scope/wm");

		AppInstance app2 = new AppInstance();
		app2.setHost(code + "-test1." + code + ".com");
		app2.setPort(20000);
		app2.setName("mda2013-test");
		app2.setProduct("MDA");
		app2.setLocation("/apps/scope/mda");

		AppInstance app3 = new AppInstance();
		app3.setHost(code + "-test1." + code + ".com");
		app3.setPort(10000);
		app3.setName("mip2013-test");
		app3.setProduct("MIP");
		app3.setLocation("/apps/scope/mip");

		AppInstance app4 = new AppInstance();
		app4.setHost(code + "-prod1." + code + ".com");
		app4.setPort(20000);
		app4.setName("wm2013-prod");
		app4.setProduct("WM");
		app4.setLocation("/apps/scope/wm");

		AppInstance app5 = new AppInstance();
		app5.setHost(code + "-prod1." + code + ".com");
		app5.setPort(20000);
		app5.setName("mda2013-prod");
		app5.setProduct("MDA");
		app5.setLocation("/apps/scope/mda");

		AppInstance app6 = new AppInstance();
		app6.setHost(code + "-prod1." + code + ".com");
		app6.setPort(10000);
		app6.setName("mip2013-prod");
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

		// HMDP
		code = "hmdp";
		app1 = new AppInstance();
		app1.setHost(code + "-uat." + code + ".com");
		app1.setPort(20000);
		app1.setName("wm2014-1-uat");
		app1.setProduct("WM");
		app1.setLocation("/apps/scope/wm1");

		AppInstance app11 = new AppInstance();
		app11.setHost(code + "-uat." + code + ".com");
		app11.setPort(21000);
		app11.setName("wm2014-2-uat");
		app11.setProduct("WM");
		app11.setLocation("/apps/scope/wm2");

		app2 = new AppInstance();
		app2.setHost(code + "-uat." + code + ".com");
		app2.setPort(20000);
		app2.setName("mda2014-uat");
		app2.setProduct("MDA");
		app2.setLocation("/apps/scope/mda");

		app3 = new AppInstance();
		app3.setHost(code + "-uat." + code + ".com");
		app3.setPort(10000);
		app3.setName("mip2013-uat");
		app3.setProduct("MIP");
		app3.setLocation("/apps/scope/mip");

		app4 = new AppInstance();
		app4.setHost(code + "-prod." + code + ".com");
		app4.setPort(20000);
		app4.setName("wm2013-1-prod");
		app4.setProduct("WM");
		app4.setLocation("/apps/scope/wm1");

		AppInstance app44 = new AppInstance();
		app44.setHost(code + "-prod." + code + ".com");
		app44.setPort(22000);
		app44.setName("wm2013-1-prod");
		app44.setProduct("WM");
		app44.setLocation("/apps/scope/wm2");

		app5 = new AppInstance();
		app5.setHost(code + "-prod." + code + ".com");
		app5.setPort(20000);
		app5.setName("mda2013-prod");
		app5.setProduct("MDA");
		app5.setLocation("/apps/scope/mda");

		app6 = new AppInstance();
		app6.setHost(code + "-prod." + code + ".com");
		app6.setPort(10000);
		app6.setName("mip2013-prod");
		app6.setProduct("MIP");
		app6.setLocation("/apps/scope/mip");

		apps = new ArrayList<AppInstance>();

		apps.add(app1);
		apps.add(app11);
		apps.add(app2);
		apps.add(app3);
		apps.add(app4);
		apps.add(app44);
		apps.add(app5);
		apps.add(app6);

		customer = customerService.getCustomerByShortName(code);
		customer.setAppInstances(apps);

		customerService.save(customer);

		// PUMA
		code = "puma";
		app1 = new AppInstance();
		app1.setHost(code + "-test1." + code + ".com");
		app1.setPort(20000);
		app1.setName("wm2013-test");
		app1.setProduct("WM");
		app1.setLocation("/apps/scope/wm");

		app2 = new AppInstance();
		app2.setHost(code + "-test1." + code + ".com");
		app2.setPort(20000);
		app2.setName("mda2013-test");
		app2.setProduct("MDA");
		app2.setLocation("/apps/scope/mda");

		app3 = new AppInstance();
		app3.setHost(code + "-test1." + code + ".com");
		app3.setPort(10000);
		app3.setName("mip2013-test");
		app3.setProduct("MIP");
		app3.setLocation("/apps/scope/mip");

		app4 = new AppInstance();
		app4.setHost(code + "-prod1." + code + ".com");
		app4.setPort(20000);
		app4.setName("wm2013-prod");
		app4.setProduct("WM");
		app4.setLocation("/apps/scope/wm");

		app5 = new AppInstance();
		app5.setHost(code + "-prod1." + code + ".com");
		app5.setPort(20000);
		app5.setName("mda2013-prod");
		app5.setProduct("MDA");
		app5.setLocation("/apps/scope/mda");

		app6 = new AppInstance();
		app6.setHost(code + "-prod1." + code + ".com");
		app6.setPort(10000);
		app6.setName("mip2013-prod");
		app6.setProduct("MIP");
		app6.setLocation("/apps/scope/mip");

		apps = new ArrayList<AppInstance>();

		apps.add(app1);
		apps.add(app2);
		apps.add(app3);
		apps.add(app4);
		apps.add(app5);
		apps.add(app6);

		customer = customerService.getCustomerByShortName(code);
		customer.setAppInstances(apps);

		customerService.save(customer);

		// MW
		code = "mw";
		app1 = new AppInstance();
		app1.setHost(code + "-uat." + code + ".com");
		app1.setPort(20000);
		app1.setName("wm2014-1-uat");
		app1.setProduct("WM");
		app1.setLocation("/apps/scope/wm1");

		app11 = new AppInstance();
		app11.setHost(code + "-uat." + code + ".com");
		app11.setPort(21000);
		app11.setName("wm2014-2-uat");
		app11.setProduct("WM");
		app11.setLocation("/apps/scope/wm2");

		app2 = new AppInstance();
		app2.setHost(code + "-uat." + code + ".com");
		app2.setPort(20000);
		app2.setName("mda2014-uat");
		app2.setProduct("MDA");
		app2.setLocation("/apps/scope/mda");

		app3 = new AppInstance();
		app3.setHost(code + "-uat." + code + ".com");
		app3.setPort(10000);
		app3.setName("mip2013-uat");
		app3.setProduct("MIP");
		app3.setLocation("/apps/scope/mip");

		app4 = new AppInstance();
		app4.setHost(code + "-prod." + code + ".com");
		app4.setPort(20000);
		app4.setName("wm2013-1-prod");
		app4.setProduct("WM");
		app4.setLocation("/apps/scope/wm1");

		app44 = new AppInstance();
		app44.setHost(code + "-prod." + code + ".com");
		app44.setPort(22000);
		app44.setName("wm2013-1-prod");
		app44.setProduct("WM");
		app44.setLocation("/apps/scope/wm2");

		app5 = new AppInstance();
		app5.setHost(code + "-prod." + code + ".com");
		app5.setPort(20000);
		app5.setName("mda2013-prod");
		app5.setProduct("MDA");
		app5.setLocation("/apps/scope/mda");

		app6 = new AppInstance();
		app6.setHost(code + "-prod." + code + ".com");
		app6.setPort(10000);
		app6.setName("mip2013-prod");
		app6.setProduct("MIP");
		app6.setLocation("/apps/scope/mip");

		apps = new ArrayList<AppInstance>();

		apps.add(app1);
		apps.add(app11);
		apps.add(app2);
		apps.add(app3);
		apps.add(app4);
		apps.add(app44);
		apps.add(app5);
		apps.add(app6);

		customer = customerService.getCustomerByShortName(code);
		customer.setAppInstances(apps);

		customerService.save(customer);

		// target
		code = "target";
		app1 = new AppInstance();
		app1.setHost(code + "-uat." + code + ".com");
		app1.setPort(20000);
		app1.setName("wm2014-1-uat");
		app1.setProduct("WM");
		app1.setLocation("/apps/scope/wm1");

		app11 = new AppInstance();
		app11.setHost(code + "-uat." + code + ".com");
		app11.setPort(21000);
		app11.setName("wm2014-2-uat");
		app11.setProduct("WM");
		app11.setLocation("/apps/scope/wm2");

		app2 = new AppInstance();
		app2.setHost(code + "-uat." + code + ".com");
		app2.setPort(20000);
		app2.setName("mda2014-uat");
		app2.setProduct("MDA");
		app2.setLocation("/apps/scope/mda");

		app3 = new AppInstance();
		app3.setHost(code + "-uat." + code + ".com");
		app3.setPort(10000);
		app3.setName("mip2013-uat");
		app3.setProduct("MIP");
		app3.setLocation("/apps/scope/mip");

		app4 = new AppInstance();
		app4.setHost(code + "-prod." + code + ".com");
		app4.setPort(20000);
		app4.setName("wm2013-1-prod");
		app4.setProduct("WM");
		app4.setLocation("/apps/scope/wm1");

		app44 = new AppInstance();
		app44.setHost(code + "-prod." + code + ".com");
		app44.setPort(22000);
		app44.setName("wm2013-1-prod");
		app44.setProduct("WM");
		app44.setLocation("/apps/scope/wm2");

		app5 = new AppInstance();
		app5.setHost(code + "-prod." + code + ".com");
		app5.setPort(20000);
		app5.setName("mda2013-prod");
		app5.setProduct("MDA");
		app5.setLocation("/apps/scope/mda");

		app6 = new AppInstance();
		app6.setHost(code + "-prod." + code + ".com");
		app6.setPort(10000);
		app6.setName("mip2013-prod");
		app6.setProduct("MIP");
		app6.setLocation("/apps/scope/mip");

		apps = new ArrayList<AppInstance>();

		apps.add(app1);
		apps.add(app11);
		apps.add(app2);
		apps.add(app3);
		apps.add(app4);
		apps.add(app44);
		apps.add(app5);
		apps.add(app6);

		customer = customerService.getCustomerByShortName(code);
		customer.setAppInstances(apps);

		customerService.save(customer);

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sdns/")
	public void seedSnds() {
		
		Customer customer = customerService.getCustomerByShortName("hmdp");
		
		
		SDN sdn1 = new SDN();
		sdn1.setName("SDN_HMDP_001");
		sdn1.setCustId(customer.getId());
		sdn1.setDesc("Fixes WM-15231, WM-15256 and tao server core dump");
		sdn1.setProductName("WM");
		sdn1.setPublishDate(new Date());
		
		sdnService.createSdn(sdn1, customer);
		
		SDN sdn2 = new SDN();
		sdn2.setName("SDN_HMDP_002");
		sdn2.setCustId(customer.getId());
		sdn2.setDesc("Fixes WM-4455 and other PE fixes");
		sdn2.setProductName("WM");
		sdn2.setPublishDate(new Date());
		
		sdnService.createSdn(sdn2, customer);
		
		SDN sdn3 = new SDN();
		sdn3.setName("SDN_HMDP_003");
		sdn3.setCustId(customer.getId());
		sdn3.setDesc("Fixes WM-67663, WM-44233");
		sdn3.setProductName("WM");
		sdn3.setPublishDate(new Date());
		
		sdnService.createSdn(sdn3, customer);
		
		
		SDN sdn4 = new SDN();
		sdn4.setName("SDN_HMDP_005");
		sdn4.setCustId(customer.getId());
		sdn4.setDesc("Fixes SalesForce ticket 7778654 ");
		sdn4.setProductName("WM");
		sdn4.setPublishDate(new Date());
		
		sdnService.createSdn(sdn4, customer);
		
		SDN sdn5 = new SDN();
		sdn5.setName("SDN_HMDP_004");
		sdn5.setCustId(customer.getId());
		sdn5.setDesc("Fixes VPT issues reported on May03, 2014");
		sdn5.setProductName("WM");
		sdn5.setPublishDate(new Date());
		
		sdnService.createSdn(sdn5, customer);
		
		SDN sdn6 = new SDN();
		sdn6.setName("SDN_HMDP_009");
		sdn6.setCustId(customer.getId());
		sdn6.setDesc("MDA-55645 User unable to login");
		sdn6.setProductName("MDA");
		sdn6.setPublishDate(new Date());
		
		sdnService.createSdn(sdn6, customer);
		
		SDN sdn7 = new SDN();
		sdn7.setName("SDN_HMDP_012");
		sdn7.setCustId(customer.getId());
		sdn7.setDesc("MDA-55645 Frequent session timeouts");
		sdn7.setProductName("MDA");
		sdn7.setPublishDate(new Date());
		
		sdnService.createSdn(sdn7, customer);
		
		
		SDN sdn8 = new SDN();
		sdn8.setName("SDN_HMDP_015");
		sdn8.setCustId(customer.getId());
		sdn8.setDesc("Salesforce ticket - crosssite scripting issuess");
		sdn8.setProductName("MDA");
		sdn8.setPublishDate(new Date());
		
		sdnService.createSdn(sdn8, customer);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/markapplied/{custShortCode}/{appName}/{sdnName}")
	public void markSDNApplied(@PathVariable String custShortCode, @PathVariable String appName, @PathVariable String sdnName) {
		
		sdnService.markSdnApplied(custShortCode, appName, sdnName);
		
	}

}
