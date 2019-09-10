package com.nzabala.services;

import java.util.ArrayList;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nzabala.bussiness.ClientManagerImpl;
import com.nzabala.bussiness.PolicyManagerImpl;
import com.nzabala.daos.ClientDAO;
import com.nzabala.daos.PolicyDAO;
import com.nzabala.models.Client;
import com.nzabala.models.Policy;

@RestController()
public class GenericServicesController extends CustomResponse{
	
	@Autowired
	ClientDAO cliDAO;
	@Autowired
	PolicyDAO poliDAO;
	
	@Autowired
	ClientManagerImpl clientImp;
	@Autowired
	PolicyManagerImpl policyImp;
	
	private static Logger LOG = Logger.getLogger("log");
	
	@RequestMapping(value = "/reload", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
    public Response reloadData() {
		
		LOG.info("Clear bbdd");
		poliDAO.deleteAll();
		cliDAO.deleteAll();
		

		try{
			LOG.info("Integrating data to bbdd");
			ArrayList<Client> clients = (ArrayList<Client>) clientImp.getClients();
			for(Client c : clients){
				// LOG.info("Insert " + c.toString());
				cliDAO.insert(c);
			}
			ArrayList<Policy> policies = (ArrayList<Policy>) policyImp.getPolicies();
			for(Policy p : policies){
				// LOG.info("Insert " + p.toString());
				poliDAO.insert(p);
			}
		}catch( Exception e) {
			LOG.error("Error insert data");
			return buildResponse("Error insert data");	
		}finally {
		}
		return buildResponse("Database Reloaded");	
    }
}
