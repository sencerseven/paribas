package com.cardif.project.policytrackingsystem.service;

import com.cardif.project.policytrackingsystem.dto.CustomerInputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerOutputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerPolicyInputDTO;
import com.cardif.project.policytrackingsystem.exception.BusinessException;
import com.cardif.project.policytrackingsystem.exception.NotFoundException;

import java.util.List;

public interface CustomerService {

    public List<CustomerOutputDTO> getCustomers(CustomerInputDTO customerInputDTO) throws NotFoundException;
    public CustomerOutputDTO saveAndUpdateCustomer(CustomerInputDTO customerInputDTO) throws BusinessException;
    public void deleteCustomer(Long id);
    public CustomerOutputDTO customerPolicyRelationAdd(CustomerPolicyInputDTO customerPolicyInputDTO) throws BusinessException;
    public CustomerOutputDTO customerPolicyRelationRemove(CustomerPolicyInputDTO customerPolicyInputDTO) throws BusinessException;
}
