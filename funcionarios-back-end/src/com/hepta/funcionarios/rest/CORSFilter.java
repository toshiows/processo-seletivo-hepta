package com.hepta.funcionarios.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

	   @Override
	   public void filter(final ContainerRequestContext request,
	                      final ContainerResponseContext response) throws IOException {
		   response.getHeaders().add("Access-Control-Allow-Origin", "*");
		   response.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, x-requested-with");
		   response.getHeaders().add("Access-Control-Allow-Credentials", "true");
		   response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		   response.getHeaders().add("Access-Control-Max-Age", "1209600");
	        
	   }
    }