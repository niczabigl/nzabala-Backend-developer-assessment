package com.nzabala.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nzabala.models.Policy;

@Repository
public interface PolicyRepository extends CrudRepository<Policy, String>{
	
}
