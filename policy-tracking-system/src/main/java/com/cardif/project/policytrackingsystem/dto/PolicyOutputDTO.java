package com.cardif.project.policytrackingsystem.dto;

public class PolicyOutputDTO {

    private Long id;

    private String description;

    private String productType;

    private String productName;

    private Integer expiry;

    private Double total;

    public PolicyOutputDTO(Long id, String description, String productType, String productName, Integer expiry, Double total) {
        this.id = id;
        this.description = description;
        this.productType = productType;
        this.productName = productName;
        this.expiry = expiry;
        this.total = total;
    }

    public PolicyOutputDTO() {
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
