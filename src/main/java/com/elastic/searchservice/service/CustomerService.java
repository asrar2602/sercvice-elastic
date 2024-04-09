package com.elastic.searchservice.service;

import com.elastic.searchservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getCustomerByCompany(String city);
    String addCustomer(Customer customer);

    void evictCache();
}
