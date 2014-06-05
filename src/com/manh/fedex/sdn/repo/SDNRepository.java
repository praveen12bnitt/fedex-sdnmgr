package com.manh.fedex.sdn.repo;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.manh.fedex.sdn.domain.SDN;

@Repository
public interface SDNRepository {
	
	public List<SDN> findAllByProductName(String prodName);
    public List<SDN> findAllByCustomerId(String custId);
    public List<SDN> findAllByCustomerName(String custName);

}
