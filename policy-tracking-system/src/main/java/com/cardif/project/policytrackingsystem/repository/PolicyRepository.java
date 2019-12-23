package com.cardif.project.policytrackingsystem.repository;

import com.cardif.project.policytrackingsystem.entity.Customer;
import com.cardif.project.policytrackingsystem.entity.Policy;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("policyRepository")
public interface PolicyRepository extends JpaRepository<Policy,Long>,
        QuerydslPredicateExecutor<Policy> {

    @Override
    List<Policy> findAll(Predicate predicate);
}
