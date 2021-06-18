package com.example.demo.interfaceAdapters;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.TransactionDataMapper;

public interface JpaTransactionRepository extends CrudRepository<TransactionDataMapper, Integer>{

}
