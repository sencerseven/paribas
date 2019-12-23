package com.cardif.project.policytrackingsystem.service;

import com.cardif.project.policytrackingsystem.dto.CustomerOutputDTO;
import com.cardif.project.policytrackingsystem.dto.PolicyInputDTO;
import com.cardif.project.policytrackingsystem.dto.PolicyOutputDTO;
import com.cardif.project.policytrackingsystem.entity.Customer;
import com.cardif.project.policytrackingsystem.entity.Policy;
import com.cardif.project.policytrackingsystem.exception.BusinessException;
import com.cardif.project.policytrackingsystem.mapper.CustomerMapperDecorator;
import com.cardif.project.policytrackingsystem.mapper.PolicyMapperDecorator;
import com.cardif.project.policytrackingsystem.predicate.PolicyPredicate;
import com.cardif.project.policytrackingsystem.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    PolicyMapperDecorator policyMapperDecorator;
    
    @Autowired
    CustomerMapperDecorator customerMapperDecorator;

    @Autowired
    PolicyPredicate policyPredicate;


    @Override
    public List<PolicyOutputDTO> getPolicies(PolicyInputDTO policyInputDTO) throws BusinessException {
        List<Policy> policies = policyRepository.findAll(policyPredicate.searchPolicy(policyInputDTO));
        if(policies.isEmpty()){
            throw new BusinessException("Poliçe Bulunamadı");
        }
        List<PolicyOutputDTO> policyDTOS = policyMapperDecorator.policiesToPoliciesDTO(policies);
        return policyDTOS;
    }

    @Override
    public void deletePolicy(Long id) throws BusinessException {
        try{
            Optional<Policy> policyOpt = policyRepository.findById(id);
            for(Customer c : policyOpt.get().getCustomers()){
                c.setPolicies(null);
            }

            policyRepository.delete(policyOpt.get());
        }catch (Exception e){
            throw  new BusinessException(e.getMessage());
        }
    }

    public PolicyOutputDTO saveAndUpdatePolicy(PolicyInputDTO policyInputDTO) throws BusinessException {
        if(policyInputDTO == null){
            throw new BusinessException("Teknik bir hata!");
        }

        Policy policy =  policyRepository.save(policyMapperDecorator.policyInputDTOToPolicy(policyInputDTO));
        if(!Optional.of(policy).isPresent()){
            throw new BusinessException("Kayıt Oluşturulamadı");
        }
        return policyMapperDecorator.policyToPolicyDTO(policy);


    }

    public Set<CustomerOutputDTO> getPolicyCustomer(Long id){
        Optional<Policy> policyOpt = policyRepository.findById(id);
        if(!policyOpt.isPresent()){
            throw new BusinessException("Poliçe Bulunamadı");
        }
        Set<CustomerOutputDTO> collect = policyOpt.get().getCustomers().stream().map(customerMapperDecorator::customerToCustomerDTO).collect(Collectors.toSet());
    
        return collect;
    }


}
