package com.nzabala.daos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nzabala.models.Client;

@Service
public interface ClientDAOI {
	void insert(Client c);
	void deleteById(String id);
	Client selectById(String id);
	void update(Client c);
	void deleteAll();
	List<Client> selectAll();
}
