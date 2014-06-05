package com.manh.fedex.sdn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.manh.fedex.sdn.domain.SDN;

@Service
public class SDNService {
	@Autowired
	private MongoOperations mongoOperation;
	
	public static SDNService getInstance()
	{
		return new SDNService();
	}
	
	public SDN getSDN(String sdnId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(sdnId));
		return mongoOperation.findOne(query, SDN.class);
	}
}
