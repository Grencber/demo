package com.example.demo.interfaceAdapters;

import org.springframework.data.repository.CrudRepository;

public interface JpaCustomerRepository extends CrudRepository<CustomerDataMapper, Integer>{

}
