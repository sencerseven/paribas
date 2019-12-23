package com.cardif.project.policytrackingsystem.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String productType;

    private String productName;

    private Integer expiry;

    private Double total;

    @ManyToMany(mappedBy = "policies",cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    Set<Customer> customers = new HashSet<Customer>();


    public Policy() {
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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
