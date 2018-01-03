package com.model;

import com.ResponseData;
import org.springframework.http.HttpStatus;

/**
 * Wrapper object for response from POST calls
 *  Contains status of POST call under field "status"
 *  Contains status code of POST call under fied "statusCode"
 *  Contains a POJO of any type(typically a DTO) under field "data" to be passed back to the user
 *
 * Created by mariannefeng on 6/8/16.
 */
public class PostResponse<T extends ResponseData> {

    private HttpStatus status;
    private int statusCode;
    private T data;

    public PostResponse(HttpStatus status, T data) {
        this.status = status;
        this.statusCode = status.value();


        this.data = data;
    }

    public PostResponse() {}

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
        this.statusCode = status.value();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() { return statusCode; }

}