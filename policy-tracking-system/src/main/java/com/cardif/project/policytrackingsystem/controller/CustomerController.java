package com.cardif.project.policytrackingsystem.controller;

import com.cardif.project.policytrackingsystem.dto.CustomerInputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerOutputDTO;
import com.cardif.project.policytrackingsystem.dto.CustomerPolicyInputDTO;
import com.cardif.project.policytrackingsystem.exception.BusinessException;
import com.cardif.project.policytrackingsystem.exception.NotFoundException;
import com.cardif.project.policytrackingsystem.model.ApiResponse;
import com.cardif.project.policytrackingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/customer")
public class CustomerController {

    /*
        --Search
        --Delete
        --Save And Update
     */

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "search" ,method = RequestMethod.POST)
    public ApiResponse<List<CustomerOutputDTO>> customerSearch(@RequestBody CustomerInputDTO customerInputDTO) throws NotFoundException {
        List<CustomerOutputDTO> customers = customerService.getCustomers(customerInputDTO);
        return new ApiResponse<List<CustomerOutputDTO>>(HttpStatus.OK,null,customers);

    }

    @RequestMapping(value = "delete/{id}" ,method = RequestMethod.DELETE)
    public ApiResponse<List<CustomerOutputDTO>> customerDelete(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return new ApiResponse<List<CustomerOutputDTO>>(HttpStatus.OK,null,null);

    }

    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    public ApiResponse customerSave(@Valid  @RequestBody CustomerInputDTO customerInputDTO, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()){
            throw new BusinessException("Boş alan bırakmayınız");
        }

        CustomerOutputDTO customerOutputDTO = customerService.saveAndUpdateCustomer(customerInputDTO);
        return new ApiResponse(HttpStatus.OK,null,customerOutputDTO);
    }

    @RequestMapping(value = "add-customer-policy" ,method = RequestMethod.POST)
    public ApiResponse customerSave(@RequestBody CustomerPolicyInputDTO customerPolicyInputDTO) throws BusinessException {
        CustomerOutputDTO customerOutputDTO = customerService.customerPolicyRelationAdd(customerPolicyInputDTO);
        return new ApiResponse(HttpStatus.OK,null,customerOutputDTO);
    }

    @RequestMapping(value = "remove-customer-policy" ,method = RequestMethod.POST)
    public ApiResponse customerDelete(@RequestBody CustomerPolicyInputDTO customerPolicyInputDTO) throws BusinessException {
        customerService.customerPolicyRelationRemove(customerPolicyInputDTO);
        return new ApiResponse(HttpStatus.OK,null,null);
    }

}
