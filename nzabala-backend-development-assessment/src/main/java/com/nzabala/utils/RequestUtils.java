package com.nzabala.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

public class RequestUtils {
	
	public static URL makeAndgetUrl(String petitionUrl) throws Exception {
		URL url = null;
		try {
			url = new URL(petitionUrl);
		} catch (MalformedURLException e) {
			// La URL es incorrecta
			throw new Exception("Url Incorrecta");
		}
		return url;
	}
	
	public static StringBuffer makeGETRequest(HttpURLConnection con) throws Exception {

		StringBuffer response = new StringBuffer();

		try {
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");

			int responseCode = con.getResponseCode();

			if (responseCode == HttpServletResponse.SC_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

				String inputLine = "";

				// obtener respuesta
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
			} else {
				throw new Exception("Error al establecer conexión con el DataSource");
			}
		} catch (IOException e) {
			throw new Exception("Conexión interrumpida");
		}
		return response;
	}
}
