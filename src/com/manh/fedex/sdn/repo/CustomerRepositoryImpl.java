package com.manh.fedex.sdn.repo;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Contact;
import com.manh.fedex.sdn.domain.Customer;

public class CustomerRepositoryImpl extends SimpleMongoRepository<Customer, String> implements CustomerRepository {

	public CustomerRepositoryImpl(MongoEntityInformation<Customer, String> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer findByCustomerName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactByCustomerId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppInstance> getAppInstancesByCustomerId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppInstance> getAppliedAppInstancesByCustomerId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppInstance> getPendingAppInstancesByCustomerId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
