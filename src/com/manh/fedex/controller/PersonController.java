package com.manh.fedex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manh.sample.Address;
import com.manh.sample.Person;
//import com.manh.sample.mongodb.CustomerRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private MongoOperations mongoOperation;
	
	

	@RequestMapping(method = RequestMethod.GET)
	public Person getPerson() {
		Person p = new Person();
		p.setFirstName("prajan");
		p.setLastName("Rajan");
		
		Address add = new Address();
		add.setStreet("Windy Ridge pkwy");
		
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(add);
		
		p.setAddress(addressList);

		mongoOperation.save(p);

		return p;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public Person listPerson() {

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("firstName").is(
				"Palanivelrajan"));

		// find the updated user object
		Person person = mongoOperation.findOne(searchUserQuery, Person.class);

		System.out.println("3. updatedUser : " + person);

		System.out.println(person.getId());

		return person;

	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/1")
	public Person modifyAdd() {

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("firstName").is(
				"prajan"));

		// find the updated user object
		Person person = mongoOperation.findOne(searchUserQuery, Person.class);

		System.out.println("3. updatedUser : " + person);

		System.out.println(person.getId());
		
		List<Address> add = person.getAddress();
		add.remove(new Address("xyz"));
		
		List<Address>  newAddress = new ArrayList<Address>();
		newAddress.add(new Address("xyz1"));
		newAddress.add(new Address("xyz2")); 		
		newAddress.add(new Address("xyz3"));
		
		person.setAddress(newAddress);
		
		mongoOperation.save(person);
		
		return person;

	}
	
	
	


}
