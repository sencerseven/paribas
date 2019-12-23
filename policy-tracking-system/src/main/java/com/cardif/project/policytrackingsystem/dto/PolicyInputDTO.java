package com.cardif.project.policytrackingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PolicyInputDTO {

    private Long id;


    @NotEmpty
    private String description;


    @NotEmpty
    private String productType;

    @NotNull
    private String productName;

    @NotNull
    private Integer expiry;

    @NotNull
    private Double total;

    public PolicyInputDTO(Long id, String description, String productType, String productName, Integer expiry, Double total) {
        this.id = id;
        this.description = description;
        this.productType = productType;
        this.productName = productName;
        this.expiry = expiry;
        this.total = total;
    }

    public PolicyInputDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
