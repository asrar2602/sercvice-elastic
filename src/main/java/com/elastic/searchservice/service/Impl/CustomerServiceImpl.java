package com.elastic.searchservice.service.Impl;

import com.elastic.searchservice.model.Customer;
import com.elastic.searchservice.model.Customers;
import com.elastic.searchservice.repository.CustomerRepository;
import com.elastic.searchservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    CustomerRepository customerRepository;
    @Override
    @Cacheable(cacheNames = "customer-cache")
    public List<Customer> getCustomerByCompany(String city) {
        return customerRepository.getCustomerByCompany(city);
    }

    @Override
    public String addCustomer(Customer customer) {
        return customerRepository.save(customer).toString();
    }

    @CacheEvict(cacheNames = "customer-cache", allEntries = true)
    @Scheduled(fixedRateString = "${caching.spring.usersTTL}", timeUnit = TimeUnit.MINUTES)
    public void evictCache(){
        log.info("Cache clear!!");
    }

}
