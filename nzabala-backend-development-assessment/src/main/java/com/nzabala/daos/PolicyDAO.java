package com.nzabala.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nzabala.models.Policy;
import com.nzabala.repository.PolicyRepository;

@Service
@Transactional
public class PolicyDAO implements PolicyDAOI{
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Override
	public void insert(Policy c) {
		policyRepository.save(c);
	}

	@Override
	public void deleteById(String id) {
		policyRepository.deleteById(id);
	}

	@Override
	public Policy selectById(String id) {
		return (Policy)policyRepository.findById(id).get();
	}

	@Override
	public void update(Policy c) {
		policyRepository.save(c);
	}
	
	@Override
	public void deleteAll() {
		policyRepository.deleteAll();
	}
	
	@Override
	public List<Policy> selectAll() {
		return (List<Policy>) policyRepository.findAll();
	}
}
