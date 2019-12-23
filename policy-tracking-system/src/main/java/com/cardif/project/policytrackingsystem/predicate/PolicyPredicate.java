package com.cardif.project.policytrackingsystem.predicate;

import com.cardif.project.policytrackingsystem.dto.PolicyInputDTO;
import com.cardif.project.policytrackingsystem.entity.QPolicy;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class PolicyPredicate {

    QPolicy policy = QPolicy.policy;

    public Predicate searchPolicy(PolicyInputDTO policyInputDTO){
        BooleanBuilder builder = new BooleanBuilder();


        if(policyInputDTO.getId() != null){
            builder.and(policy.id.eq(policyInputDTO.getId()));
        }

        if(StringUtils.isNotEmpty(policyInputDTO.getDescription())){
            builder.and(policy.description.eq(policyInputDTO.getDescription()));
        }

        if(StringUtils.isNotEmpty(policyInputDTO.getProductName())){
            builder.and(policy.productName.eq(policyInputDTO.getProductName()));
        }

        if(StringUtils.isNotEmpty(policyInputDTO.getProductType())){
            builder.and(policy.productType.eq(policyInputDTO.getProductType()));
        }

        if(policyInputDTO.getTotal() != null){
            builder.and(policy.total.eq(policyInputDTO.getTotal()));
        }

        if(policyInputDTO.getExpiry() != null){
            builder.and(policy.expiry.eq(policyInputDTO.getExpiry()));
        }

        return builder;

    }

}
