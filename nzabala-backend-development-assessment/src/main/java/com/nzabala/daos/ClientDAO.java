package com.nzabala.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nzabala.models.Client;
import com.nzabala.repository.ClientRepository;

@Service
@Transactional
public class ClientDAO implements ClientDAOI{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public void insert(Client c) {
		clientRepository.save(c);
	}

	@Override
	public void deleteById(String id) {
		clientRepository.deleteById(id);
	}

	@Override
	public Client selectById(String id) {
		return (Client)clientRepository.findById(id).get();
	}

	@Override
	public void update(Client c) {
		clientRepository.save(c);
	}
	
	@Override
	public void deleteAll() {
		clientRepository.deleteAll();
	}
	
	@Override
	public List<Client> selectAll() {
		return (List<Client>) clientRepository.findAll();
	}
}
