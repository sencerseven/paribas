package com.cardif.project.policytrackingsystem.mapper;

import com.cardif.project.policytrackingsystem.dto.CustomerInputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerOutputDTO;
import com.cardif.project.policytrackingsystem.entity.Customer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(CustomerMapperDecorator.class)
public interface CustomerMapper {

    CustomerOutputDTO customerToCustomerDTO(Customer customer);
    List<CustomerOutputDTO> customersToCustomerDTOs(List<Customer> customers);

    Customer customerInputDTOToCustomer(CustomerInputDTO customerInputDTO);
}
