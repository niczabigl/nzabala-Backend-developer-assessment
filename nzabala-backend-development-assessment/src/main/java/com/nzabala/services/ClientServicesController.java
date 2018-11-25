package com.nzabala.services;

import java.util.ArrayList;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nzabala.bussiness.ClientManagerImpl;
import com.nzabala.models.Client;

@RestController()
public class ClientServicesController extends CustomResponse{
	
	private static Logger LOG = Logger.getLogger("log");
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
    public Response getAllClients() {
		
		LOG.info("GETTING all clients at: /clients");
		ClientManagerImpl clientImp = new ClientManagerImpl();
		clientImp.getDataSource();
		
		return buildResponse(!clientImp.getClients().isEmpty()?clientImp.getClients():null);	
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientById(@PathVariable("id") String id) {
		
		LOG.info("GETTING /clients/{id} ->" + id);
		ClientManagerImpl clientImp = new ClientManagerImpl();
		ArrayList<Client> resClient = (ArrayList<Client>) clientImp.filterDataById(id);
		
		return buildResponse(resClient);
    }
}
