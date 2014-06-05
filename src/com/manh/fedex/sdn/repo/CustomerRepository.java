package com.manh.fedex.sdn.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manh.fedex.sdn.domain.AppInstance;
import com.manh.fedex.sdn.domain.Contact;
import com.manh.fedex.sdn.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByCustomerName(String name);
    public Contact getContactByCustomerId(String id);
    public List<AppInstance> getAppInstancesByCustomerId(String id);
    public List<AppInstance> getAppliedAppInstancesByCustomerId(String id);
    public List<AppInstance> getPendingAppInstancesByCustomerId(String id);

}
