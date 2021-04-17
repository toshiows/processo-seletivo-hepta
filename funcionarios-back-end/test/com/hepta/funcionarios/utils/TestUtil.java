package com.hepta.funcionarios.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class TestUtil {

	public static WebTarget target(String uri, String local) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		return client.target(UriBuilder.fromUri(uri+local).build());
	}
}
