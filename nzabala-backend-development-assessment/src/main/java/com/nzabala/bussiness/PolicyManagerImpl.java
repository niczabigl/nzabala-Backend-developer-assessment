package com.nzabala.bussiness;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nzabala.dtos.UserPolicies;
import com.nzabala.models.Client;
import com.nzabala.models.Policy;
import com.nzabala.services.ManagerI;
import com.nzabala.utils.RequestUtils;

public class PolicyManagerImpl implements ManagerI {

public static final String DATASOURCE = "http://www.mocky.io/v2/580891a4100000e8242b75c5";
	
	List<Policy> policies = new ArrayList<Policy>();
	List<Client> clients = new ArrayList<Client>();
	
	public PolicyManagerImpl(){
		this.getDataSource();
		this.clients = new ClientManagerImpl().getClients();
	}
	
	public void getDataSource() {
		try {
			URL url = RequestUtils.makeAndgetUrl(DATASOURCE);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			StringBuffer response = RequestUtils.makeGETRequest(con);
			JSONObject jsonResponse = new JSONObject(response!=null?response.toString():null);
			if(jsonResponse != null){
				ObjectMapper om = new ObjectMapper();
				JSONArray jsonPolicies = jsonResponse.has("policies") ? jsonResponse.getJSONArray("policies"): null;
				if(jsonPolicies!=null){
					for(int i = 0 ; i< jsonPolicies.length() ; i++){
						policies.add(om.readValue(jsonPolicies.get(i).toString(), Policy.class));
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<?> filterDataById(String id) {
		
		ArrayList<Policy> filteredPolicies = new ArrayList<Policy>();
		for(Policy p : this.policies){
			if(p.getId().equals(id)){
				filteredPolicies.add(p);
			}
		}		
		return filteredPolicies;
	}
	
	@Override
	public ArrayList<?> filterDataByName(String name) {
		ArrayList<Policy> policies = new ArrayList<Policy>();
		ArrayList<Client> clients = new ArrayList<Client>();
		for (Client c : this.clients){
			if(c.getName().equals(name)){
				clients.add(c);
			}
		}
		for(Client c : clients){
			for(Policy p : this.policies){
				if(p.getClientId().equals(c.getId())){
					policies.add(p);
				}
			}
		}
		return policies;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}
	
	//user linked to a policy number
	public ArrayList<Client> getClientByPolicyId(String id){
		@SuppressWarnings("unchecked")
		ArrayList<Client> clients = new ArrayList<Client>();
		ArrayList<Policy> policies = (ArrayList<Policy>)this.filterDataById(id);
		if(policies != null && !policies.isEmpty()){
			for(Client c :this.clients){
				if(c.getId().equals(policies.get(0).getClientId())){
					clients.add(c);
				}
			}
		}
		return clients;
	}
	//list of policies linked to a user name ( i see there are multiple Users with same name so is better use userid than name)
	@SuppressWarnings("unchecked")
	public ArrayList<UserPolicies> getUserPoliciesByUserName(String userName){
		ArrayList<UserPolicies> ups = new ArrayList<UserPolicies>();
		ArrayList<Policy> policies = (ArrayList<Policy>)this.filterDataByName(userName);
		
		if(policies != null && !policies.isEmpty()){
			for(Client c :this.clients){
				if(c.getName().equals(userName)){
					UserPolicies up = new UserPolicies();
					up.setUserId(c.getId());
					up.setUserName(c.getName());
					for(Policy p : policies){
						if(c.getId().equals(p.getClientId())){
							up.addPolicy(p);
						}
					}
					ups.add(up);
				}				
			}
		}
		return ups;
	}
}
