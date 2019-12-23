package com.cardif.project.policytrackingsystem.dto;

public class CustomerPolicyInputDTO {

    private Long customerID;
    private Long policyID;

    public CustomerPolicyInputDTO(Long customerID, Long policyID) {
        this.customerID = customerID;
        this.policyID = policyID;
    }

    public CustomerPolicyInputDTO() {
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getPolicyID() {
        return policyID;
    }

    public void setPolicyID(Long policyID) {
        this.policyID = policyID;
    }
}
