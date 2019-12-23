package com.cardif.project.policytrackingsystem.advice;

import com.cardif.project.policytrackingsystem.exception.BusinessException;
import com.cardif.project.policytrackingsystem.exception.NotFoundException;
import com.cardif.project.policytrackingsystem.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ApiResponse exception(Exception ex){
        logger.error("Exception Catch!" , ex);
        return new ApiResponse(HttpStatus.EXPECTATION_FAILED,ex.getMessage(),null);
    }


    @ExceptionHandler(NotFoundException.class)
    public ApiResponse exception(NotFoundException ex){
        logger.error("Exception Catch!" , ex);
        return new ApiResponse(HttpStatus.NOT_FOUND,ex.getMessage(),null);
    }

    @ExceptionHandler(BusinessException.class)
    public ApiResponse exception(BusinessException ex){
        logger.error("Exception Catch!" , ex);
        return new ApiResponse(HttpStatus.NOT_ACCEPTABLE,ex.getMessage(),null);
    }

}
