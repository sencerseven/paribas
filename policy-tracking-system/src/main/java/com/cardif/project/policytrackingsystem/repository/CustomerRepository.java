package com.cardif.project.policytrackingsystem.repository;

import com.cardif.project.policytrackingsystem.entity.Customer;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer,Long>,
        QuerydslPredicateExecutor<Customer> {

    @Override
    List<Customer> findAll(Predicate predicate);

}
