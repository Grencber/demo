package com.example.demo.interfaceAdapters;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.AccountDataMapper;

public interface JpaAccountRepository extends CrudRepository<AccountDataMapper, Integer>{

}
