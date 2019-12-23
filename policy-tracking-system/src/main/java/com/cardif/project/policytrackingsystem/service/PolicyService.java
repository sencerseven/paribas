package com.cardif.project.policytrackingsystem.service;

import com.cardif.project.policytrackingsystem.dto.CustomerOutputDTO;
import com.cardif.project.policytrackingsystem.dto.PolicyInputDTO;
import com.cardif.project.policytrackingsystem.dto.PolicyOutputDTO;
import com.cardif.project.policytrackingsystem.exception.BusinessException;
import com.cardif.project.policytrackingsystem.exception.NotFoundException;

import java.util.List;
import java.util.Set;

public interface PolicyService {

    public List<PolicyOutputDTO> getPolicies(PolicyInputDTO policyInputDTO) throws BusinessException;
    public void deletePolicy(Long id) throws BusinessException;
    public PolicyOutputDTO saveAndUpdatePolicy(PolicyInputDTO policyInputDTO) throws BusinessException;
    public Set<CustomerOutputDTO> getPolicyCustomer(Long id) throws NotFoundException;
}
