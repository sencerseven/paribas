package com.cardif.project.policytrackingsystem.service;

import com.cardif.project.policytrackingsystem.dto.CustomerInputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerOutputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerPolicyInputDTO;
import com.cardif.project.policytrackingsystem.entity.Customer;
import com.cardif.project.policytrackingsystem.entity.Policy;
import com.cardif.project.policytrackingsystem.exception.BusinessException;
import com.cardif.project.policytrackingsystem.exception.NotFoundException;
import com.cardif.project.policytrackingsystem.mapper.CustomerMapperDecorator;
import com.cardif.project.policytrackingsystem.predicate.CustomerPredicate;
import com.cardif.project.policytrackingsystem.repository.CustomerRepository;
import com.cardif.project.policytrackingsystem.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    CustomerMapperDecorator customerMapperDecorator;

    @Autowired
    private CustomerPredicate customerPredicate;

    @Override
    public List<CustomerOutputDTO> getCustomers(CustomerInputDTO customerInputDTO) throws NotFoundException {

        List<Customer> customers = customerRepository.findAll(customerPredicate.searchCustomer(customerInputDTO));
        if(customers.isEmpty()){
            throw new NotFoundException("Customers Not Found!");
        }


        List<CustomerOutputDTO> customerDTOs = customerMapperDecorator.customersToCustomerDTOs(customers);
        return customerDTOs;
    }

    @Override
    public void deleteCustomer(Long id) {
        try{
            customerRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
    }

    public CustomerOutputDTO saveAndUpdateCustomer(CustomerInputDTO customerInputDTO) throws BusinessException {
        if(customerInputDTO == null){
            throw new BusinessException("Bir Sorun Oluştu");
        }
        Customer customer =  customerRepository.save(customerMapperDecorator.customerInputDTOToCustomer(customerInputDTO));
        if(!Optional.of(customer).isPresent()){
            throw new BusinessException("Kayıt Oluşturulamadı");
        }
        return customerMapperDecorator.customerToCustomerDTO(customer);
    }


    public CustomerOutputDTO customerPolicyRelationAdd(CustomerPolicyInputDTO customerPolicyInputDTO) throws BusinessException {
        if(customerPolicyInputDTO == null){
            throw new BusinessException("Bir Sorun Oluştu");
        }
        Optional<Customer> customerOpt = customerRepository.findById(customerPolicyInputDTO.getCustomerID());
        if(!customerOpt.isPresent()){
            throw  new BusinessException("Kullanıcı Bulunamadı");
        }

        Optional<Policy> policyOpt = policyRepository.findById(customerPolicyInputDTO.getPolicyID());
        if(!policyOpt.isPresent()){
            throw new BusinessException("Policy Bulunamadı");
        }

        Customer customer = customerOpt.get();
        Policy policy = policyOpt.get();

        customer.getPolicies().add(policy);
        policy.getCustomers().add(customer);
        Customer save = customerRepository.save(customer);


        return customerMapperDecorator.customerToCustomerDTO(save);
    }


    public CustomerOutputDTO customerPolicyRelationRemove(CustomerPolicyInputDTO customerPolicyInputDTO) throws BusinessException {
        if(customerPolicyInputDTO == null){
            throw new BusinessException("Bir Sorun Oluştu");
        }
        Optional<Customer> customerOpt = customerRepository.findById(customerPolicyInputDTO.getCustomerID());
        if(!customerOpt.isPresent()){
            throw  new BusinessException("Kullanıcı Bulunamadı");
        }

        Optional<Policy> policyOpt = policyRepository.findById(customerPolicyInputDTO.getPolicyID());
        if(!policyOpt.isPresent()){
            throw new BusinessException("Policy Bulunamadı");
        }

        Customer customer = customerOpt.get();
        Policy policy = policyOpt.get();

        customer.getPolicies().remove(policy);
        policy.getCustomers().remove(customer);
        Customer save = customerRepository.save(customer);


        return customerMapperDecorator.customerToCustomerDTO(save);
    }

}