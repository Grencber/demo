package com.example.demo.interfaceAdapters;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.CustomerDataMapper;

public interface JpaCustomerRepository extends CrudRepository<CustomerDataMapper, Integer>{

}
