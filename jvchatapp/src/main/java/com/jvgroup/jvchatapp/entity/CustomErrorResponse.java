package com.jvgroup.jvchatapp.entity;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse extends RuntimeException{

    private HttpStatus status;
    private String message;
    private long timestamp;

    public CustomErrorResponse(){}

    public CustomErrorResponse(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public CustomErrorResponse(HttpStatus status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public CustomErrorResponse(String message, HttpStatus status, String message1, long timestamp) {
        super(message);
        this.status = status;
        this.message = message1;
        this.timestamp = timestamp;
    }

    public CustomErrorResponse(String message, Throwable cause, HttpStatus status, String message1, long timestamp) {
        super(message, cause);
        this.status = status;
        this.message = message1;
        this.timestamp = timestamp;
    }

    public CustomErrorResponse(Throwable cause, HttpStatus status, String message, long timestamp) {
        super(cause);
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

