package com.nzabala.bussiness;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nzabala.models.Client;
import com.nzabala.services.ManagerI;
import com.nzabala.utils.RequestUtils;

@Service
@Configurable
public class ClientManagerImpl implements ManagerI {
	
	public static final String DATASOURCE = "http://www.mocky.io/v2/5808862710000087232b75ac";
	
	static List<Client> clients = new ArrayList<Client>();
	
	public ClientManagerImpl(){
		this.getDataSource();
	}
	
	public void getDataSource() {
		try {
			URL url = RequestUtils.makeAndgetUrl(DATASOURCE);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			StringBuffer response = RequestUtils.makeGETRequest(con);
			JSONObject jsonResponse = new JSONObject(response!=null?response.toString():null);
			if(jsonResponse != null){
				ObjectMapper om = new ObjectMapper();
				JSONArray jsonClients = jsonResponse.has("clients") ? jsonResponse.getJSONArray("clients"): null;
				if(jsonClients!=null){
					for(int i = 0 ; i< jsonClients.length() ; i++){
						clients.add(om.readValue(jsonClients.get(i).toString(), Client.class));
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
		ArrayList<Client> clients = new ArrayList<Client>();
		for(Client c : this.clients){
			if(c.getId().contains(id)){
				clients.add(c);
			}
		}
		return clients;
	}

	@Override
	public ArrayList<?> filterDataByName(String name) {
		ArrayList<Client> clients = new ArrayList<Client>();
		for(Client c : this.clients){
			if(c.getName().contains(name)){
				clients.add(c);
			}
		}
		return clients;
	}

	public List<Client> getClients() {
		return clients;
	}	
	
}
