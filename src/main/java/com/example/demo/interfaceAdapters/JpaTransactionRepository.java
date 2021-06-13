package com.example.demo.interfaceAdapters;

import org.springframework.data.repository.CrudRepository;

public interface JpaTransactionRepository extends CrudRepository<TransactionDataMapper, Integer>{

}
