package com.cardif.project.policytrackingsystem.mapper;

import com.cardif.project.policytrackingsystem.dto.PolicyInputDTO;
import com.cardif.project.policytrackingsystem.dto.PolicyOutputDTO;
import com.cardif.project.policytrackingsystem.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class PolicyMapperDecorator implements PolicyMapper {

    @Autowired
    PolicyMapper policyMapper;

    @Override
    public List<PolicyOutputDTO> policiesToPoliciesDTO(List<Policy> policies){
        List<PolicyOutputDTO> collect = policies.stream().map(policyMapper::policyToPolicyDTO).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Policy policyInputDTOToPolicy(PolicyInputDTO policyInputDTO){
        Policy policy = new Policy();
        policy.setId(policyInputDTO.getId());
        policy.setDescription(policyInputDTO.getDescription());
        policy.setExpiry(policyInputDTO.getExpiry());
        policy.setProductName(policyInputDTO.getProductName());
        policy.setProductType(policyInputDTO.getProductType());
        policy.setTotal(policyInputDTO.getTotal());

        return policy;
    }


}
