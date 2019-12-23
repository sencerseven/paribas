package com.cardif.project.policytrackingsystem.controller;

import com.cardif.project.policytrackingsystem.dto.CustomerOutputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerPolicyInputDTO;
import com.cardif.project.policytrackingsystem.dto.PolicyInputDTO;
import com.cardif.project.policytrackingsystem.dto.PolicyOutputDTO;
import com.cardif.project.policytrackingsystem.exception.BusinessException;
import com.cardif.project.policytrackingsystem.model.ApiResponse;
import com.cardif.project.policytrackingsystem.service.CustomerService;
import com.cardif.project.policytrackingsystem.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("/policy")
public class PolicyController {

      /*
        --Search
        --Delete
        --Save And Update
     */


    @Autowired
    PolicyService policyService;


    @RequestMapping(value = "search" ,method = RequestMethod.POST)
    public ApiResponse<List<PolicyOutputDTO>> policySearch(@RequestBody PolicyInputDTO policyInputDTO) throws BusinessException{
        List<PolicyOutputDTO> policies = policyService.getPolicies(policyInputDTO);
        return new ApiResponse<List<PolicyOutputDTO>>(HttpStatus.OK,null,policies);
    }

    @RequestMapping(value = "delete/{id}" ,method = RequestMethod.DELETE)
    public ApiResponse policyDelete(@PathVariable("id")Long id) throws BusinessException{
        policyService.deletePolicy(id);
        return new ApiResponse(HttpStatus.OK,null,null);
    }

    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    public ApiResponse policySaveAndUpdate(@Valid @RequestBody PolicyInputDTO policyInputDTO , BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()){
            throw new BusinessException("Lütfen Boş Alan Bırakmayınız");
        }

        PolicyOutputDTO policyOutputDTO = policyService.saveAndUpdatePolicy(policyInputDTO);
        return new ApiResponse(HttpStatus.OK,null,policyOutputDTO);
    }

    @RequestMapping(value = "policy-customer/{id}" ,method = RequestMethod.GET)
    public ApiResponse customerSave(@PathVariable("id") Long id) throws BusinessException {
        Set<CustomerOutputDTO> policyCustomer = policyService.getPolicyCustomer(id);
        return new ApiResponse(HttpStatus.OK,null,policyCustomer);
    }




}
