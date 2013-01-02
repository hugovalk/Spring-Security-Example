package com.devdiscoveries.view;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope(value="request")
@Path("/hello")
public class HelloResource {

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
