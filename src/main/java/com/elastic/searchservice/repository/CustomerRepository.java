package com.elastic.searchservice.repository;

import com.elastic.searchservice.model.Customer;
import com.elastic.searchservice.model.Customers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    static final Logger log = LoggerFactory.getLogger(CustomerRepository.class);
    @Cacheable(cacheNames = "customer-cache")
    @Query(value = "CALL SelectCustomerByCompany(:company);", nativeQuery = true)
    List<Customer> getCustomerByCompany(String company);

    @Override
    Customer save(Customer entity);
}
