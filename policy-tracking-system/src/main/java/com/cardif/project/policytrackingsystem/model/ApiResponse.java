package com.cardif.project.policytrackingsystem.model;

import org.springframework.http.HttpStatus;

public class ApiResponse<T>  {

    private HttpStatus status;
    private Integer code;
    private String error;
    private T data;

    public ApiResponse(HttpStatus status, String error, T data) {
        this.status = status;
        this.error = error;
        this.data = data;
        this.code = status.value();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
