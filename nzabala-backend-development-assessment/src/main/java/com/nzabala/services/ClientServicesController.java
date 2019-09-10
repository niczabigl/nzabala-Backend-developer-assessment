package com.nzabala.services;

import java.util.ArrayList;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nzabala.bussiness.ClientManagerImpl;
import com.nzabala.daos.ClientDAO;
import com.nzabala.models.Client;

@RestController()
public class ClientServicesController extends CustomResponse{
	
	@Autowired
	ClientDAO cliDAO;
	
	@Autowired 
	ClientManagerImpl clientImp;
	
	private static Logger LOG = Logger.getLogger("log");
	
	
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
    public Response getAllClients() {
		
		LOG.info("GETTING all clients at: /clients");
		ArrayList<Client> clients = (ArrayList<Client>) cliDAO.selectAll();
		return buildResponse(!clients.isEmpty()?clients:null);	
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientById(@PathVariable("id") String id) {
		
		LOG.info("GETTING /clients/{id} ->" + id);
		ArrayList<Client> resClient = new ArrayList<Client>();
		resClient.addAll((ArrayList<Client>) clientImp.filterDataById(id));
		resClient.addAll((ArrayList<Client>) clientImp.filterDataByName(id));
		
		return buildResponse(resClient);
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/clients/crud/{id}", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectClientById(@PathVariable("id") String id) {
		
		LOG.info("GETTING /clients/crud/{id} ->" + id);
		ArrayList<Client> resClient = new ArrayList<Client>();
		resClient.add((Client)cliDAO.selectById(id));
		
		return buildResponse(resClient);
    }
}
