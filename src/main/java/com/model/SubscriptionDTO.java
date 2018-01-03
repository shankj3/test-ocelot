package com.model;

/**
 * Created by mariannefeng on 9/7/16.
 */
public class SubscriptionDTO {

    private String callbackURL;
    private String criteria;
    private String eventType;


    public SubscriptionDTO() {}

    public String getCallbackURL() {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}