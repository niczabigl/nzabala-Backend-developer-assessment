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

import com.nzabala.bussiness.PolicyManagerImpl;
import com.nzabala.dtos.UserPolicies;
import com.nzabala.models.Client;

@RestController
public class PolicyServicesController extends CustomResponse {

private static Logger LOG = Logger.getLogger("log");
	
	@RequestMapping(value = "/policies", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
    public Response getAllPolicies() {
		
		LOG.info("GETTING all policies at: /policies");
		PolicyManagerImpl policyImp = new PolicyManagerImpl();
		policyImp.getDataSource();
		
		return buildResponse(!policyImp.getPolicies().isEmpty()?policyImp.getPolicies():null);	
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/policies/policy/{id}", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientByPolicyId(@PathVariable("id") String id) {
		
		LOG.info("GETTING /policies/clientid/{id} ->" + id);
		PolicyManagerImpl policyImp = new PolicyManagerImpl();
		ArrayList<Client> resClient = policyImp.getClientByPolicyId(id);
		
		return buildResponse(resClient);
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/policies/username/{userName}", method = RequestMethod.GET)
	@CrossOrigin()
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserPoliciesByUserName(@PathVariable("userName") String userName) {
		
		LOG.info("GETTING /policies/username/{userName} ->" + userName);
		PolicyManagerImpl policyImp = new PolicyManagerImpl();
		ArrayList<UserPolicies> resUp = policyImp.getUserPoliciesByUserName(userName);
		
		return buildResponse(resUp);
    }

}
