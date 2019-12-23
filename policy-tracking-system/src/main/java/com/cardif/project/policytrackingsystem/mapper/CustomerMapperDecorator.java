package com.cardif.project.policytrackingsystem.mapper;

import com.cardif.project.policytrackingsystem.dto.CustomerInputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerOutputDTO;
import com.cardif.project.policytrackingsystem.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class CustomerMapperDecorator implements CustomerMapper {

    @Autowired
    private CustomerMapper delegate;

    @Override
    public List<CustomerOutputDTO> customersToCustomerDTOs(List<Customer> customers){
        List<CustomerOutputDTO> collect = customers.stream().map(delegate::customerToCustomerDTO).collect(Collectors.toList());
        return collect;
    }

    public Customer customerInputDTOToCustomer(CustomerInputDTO customerInputDTO){
        Customer customer = new Customer();
        customer.setId(customerInputDTO.getId());
        customer.setTckNumber(customerInputDTO.getTckNumber());
        customer.setFirstName(customerInputDTO.getFirstName());
        customer.setLastName(customerInputDTO.getLastName());
        customer.setPhoneNumber(customerInputDTO.getPhoneNumber());
        customer.setBirthDate(customerInputDTO.getBirthDate());
        customer.setAddress(customerInputDTO.getAddress());

        return customer;
    }

}
