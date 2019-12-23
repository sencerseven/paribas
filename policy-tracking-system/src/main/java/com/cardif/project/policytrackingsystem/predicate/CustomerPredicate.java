package com.cardif.project.policytrackingsystem.predicate;

import com.cardif.project.policytrackingsystem.dto.CustomerInputDTO;
import com.cardif.project.policytrackingsystem.entity.QCustomer;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CustomerPredicate {

    QCustomer customer = QCustomer.customer;

    public Predicate searchCustomer(CustomerInputDTO customerInputDTO){
        BooleanBuilder builder = new BooleanBuilder();

        if(customerInputDTO.getId() != null){
            builder.and(customer.id.eq(customerInputDTO.getId()));
        }

        if(!StringUtils.isEmpty(customerInputDTO.getAddress())){
            builder.and(customer.address.eq(customerInputDTO.getAddress()));
        }

        if(!StringUtils.isEmpty(customerInputDTO.getFirstName())){
            builder.and(customer.firstName.eq(customerInputDTO.getFirstName()));
        }

        if(!StringUtils.isEmpty(customerInputDTO.getLastName())){
            builder.and(customer.lastName.eq(customerInputDTO.getLastName()));
        }

        return builder;
    }



}
