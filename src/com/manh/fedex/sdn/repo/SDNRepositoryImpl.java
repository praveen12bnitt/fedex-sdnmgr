package com.manh.fedex.sdn.repo;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.manh.fedex.sdn.domain.SDN;

public class SDNRepositoryImpl extends SimpleMongoRepository<SDN, String> implements SDNRepository {

	public SDNRepositoryImpl(MongoEntityInformation<SDN, String> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SDN> findAllByProductName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SDN> findAllByCustomerId(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SDN> findAllByCustomerName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
