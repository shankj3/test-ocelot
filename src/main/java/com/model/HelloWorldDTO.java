package com.model;

import com.ResponseData;

/**
 * Fake object for Testing purposes
 *
 * Created by mariannefeng on 6/8/16.
 */
public class HelloWorldDTO implements ResponseData {

    private long id;

    private String value;

    public HelloWorldDTO() {}

    public HelloWorldDTO(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}