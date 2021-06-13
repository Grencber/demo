package com.example.demo.interfaceAdapters;

import org.springframework.data.repository.CrudRepository;

public interface JpaAccountRepository extends CrudRepository<AccountDataMapper, Integer>{

}
