package com.cardif.project.policytrackingsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CustomerOutputDTO {

    private Long id;

    private String tckNumber;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    private String address;

    private String phoneNumber;

    public CustomerOutputDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTckNumber() {
        return this.tckNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTckNumber(String tckNumber) {
        this.tckNumber = tckNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
