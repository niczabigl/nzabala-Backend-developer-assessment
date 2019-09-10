package com.nzabala.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nzabala.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String>{
	
}
