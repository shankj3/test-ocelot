//package com.controller;
//
//import com.HelloWorldClient;
//import com.lok8.ac.IAuth;
//import com.model.HelloWorldDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * This is a simple rest client for easier demo-ing that rest client indeed does work
// *
// * Created by mariannefeng on 6/8/16.
// */
//@RestController
//public class AnotherResource {
//
//    @Autowired
//    private HelloWorldClient client;
//
//    @Autowired
//    private IAuth auth;
//
//    @RequestMapping(method = RequestMethod.GET, value="/client", produces = "application/json;charset=UTF-8")
//    public HelloWorldDTO performClientCall() {
////        HelloWorldDTO basicObj = client.basicGet();
//        basicObj.setValue("good bye world");
//        return basicObj;
//    }
//
//
//}
