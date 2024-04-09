package com.elastic.searchservice.controller;


import com.elastic.searchservice.model.Customer;
import com.elastic.searchservice.model.Customers;
import com.elastic.searchservice.model.User;
import com.elastic.searchservice.service.CustomerService;
import com.elastic.searchservice.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;

    @Value("${apiKey}")
    String apiKey;

    @Value("${sm://testname}")
    String testname;


    @RequestMapping(value = "/api/v1/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage(){
        return "Hello"+"Friend";
    }

    @RequestMapping(value = "/api/v1/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage2(@RequestParam(name = "username") String uname){
        return "Hi "+uname+": test-"+apiKey+": testname-"+testname;
    }

    @RequestMapping(value = "/api/v1/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUserFromDB(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/api/v1/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomerFromDBByCity(@RequestParam(name = "company") String company) throws InterruptedException {
        List customer= customerService.getCustomerByCompany(company);
        return customer;
    }

    @RequestMapping(value = "/api/v1/addcustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomer(@RequestBody Customer customer){
       return customerService.addCustomer(customer);
    }

}