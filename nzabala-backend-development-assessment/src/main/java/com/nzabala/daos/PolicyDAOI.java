package com.nzabala.daos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nzabala.models.Policy;

@Service
public interface PolicyDAOI {
	void insert(Policy c);
	void deleteById(String id);
	Policy selectById(String id);
	void update(Policy c);
	void deleteAll();
	List<Policy> selectAll();
}
