package com.devdiscoveries.view;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Hello World REST resource, which is greeting the visistor. Supports a general and a personalized greeting. 
 * 
 * @author hugovalk
 *
 */
@Component
@Scope(value="request")
@Path("/hello")
public class HelloResource {

	/**
	 * Get a personalized hello message using an extra path parameter. 
	 * Using url /hello/hugo returns an HTML document with Hello Hugo! 
	 * 
	 * @param name the name to use in the greeting.
	 * @return a HTTP response containing the message. 
	 */
	@GET
	@Path("/{name}")
	public String helloWithName(@DefaultValue("World") @PathParam("name") final String name) {
		final StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<head></head>");
		builder.append("<body><h1>");
		builder.append("hello ").append(StringUtils.capitalize(name)).append("!");
		builder.append("</h1></body></html>");
		return builder.toString();
	}
	
	/**
	 * Get a general hello message. 
	 * 
	 * @return a HTTP response containing the message. 
	 */
	@GET
	public Response hello() {
		final StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<head></head>");
		builder.append("<body><h1>");
		builder.append("hello World!");
		builder.append("</h1></body></html>");
		return Response.status(200).entity(builder.toString()).build();
	}
}
