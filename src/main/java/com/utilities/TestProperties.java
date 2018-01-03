package com.utilities;

/**
 * Ths is an example of a custom validator class that reads in values from the JVM
 *
 * Might not need to write a custom validator if the validation requirement is just that the
 * value can't be null and needs a default value of X
 *
 * Currently fails HARD if the user does not pass in a valid URL
 *
 * Created by mariannefeng on 6/20/16.
 */
//@ConfigurationProperties
//@Component
//public class TestProperties implements Validator {
//
//    public String getServiceUrl() {
//        return serviceUrl;
//    }
//
//    public void setServiceUrl(String serviceUrl) {
//        this.serviceUrl = serviceUrl;
//    }
//
//    private String serviceUrl;
//
//    public boolean supports(Class<?> clazz) {
//        return clazz == TestProperties.class;
//    }
//
//    public void validate(Object target, Errors errors) {
//        //custom validation logic goes in here
//        ValidationUtils.rejectIfEmpty(errors, "serviceUrl", "serviceUrl.empty" );
//
//        TestProperties properties = (TestProperties) target;
//        try {
//            URL validateUrl = new URL(properties.getServiceUrl());
//            this.serviceUrl = properties.getServiceUrl();
//        } catch (MalformedURLException e) {
//            errors.rejectValue("serviceUrl", "Your have passed in an invalid URL");
//        }
//    }
//}