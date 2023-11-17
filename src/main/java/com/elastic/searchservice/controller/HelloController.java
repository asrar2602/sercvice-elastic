package com.elastic.searchservice.controller;


import com.elastic.searchservice.Utils.TestConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    TestConnection testConnection;

    @RequestMapping(value = "/api/v1/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage(){
        return "Hello"+"Friend";
    }

    @RequestMapping(value = "/api/v1/testconnection", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String testconnection(){
        return testConnection.getResponse();
    }

}

