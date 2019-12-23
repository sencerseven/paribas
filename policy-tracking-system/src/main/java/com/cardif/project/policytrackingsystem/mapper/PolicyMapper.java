package com.cardif.project.policytrackingsystem.mapper;

import com.cardif.project.policytrackingsystem.dto.PolicyInputDTO;
import com.cardif.project.policytrackingsystem.dto.PolicyOutputDTO;
import com.cardif.project.policytrackingsystem.entity.Policy;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(PolicyMapperDecorator.class)
public interface PolicyMapper {


    PolicyOutputDTO policyToPolicyDTO(Policy policy);
    List<PolicyOutputDTO> policiesToPoliciesDTO(List<Policy> policies);

    Policy policyInputDTOToPolicy(PolicyInputDTO policyInputDTO);
}
