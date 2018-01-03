package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Mimicks a simple REST client
 *
 * Created by mariannefeng on 6/8/16.
 */
@Service
public class HelloWorldClient {

    private static Logger logger = LoggerFactory.getLogger(HelloWorldClient.class);

    @Autowired
    private RestTemplate template;

//    @Autowired
//    private TestProperties testProperties;

    public HelloWorldClient() {}

//    public HelloWorldDTO basicGet() {
//        return this.template.getForObject(testProperties.getServiceUrl(), HelloWorldDTO.class);
//    }

}