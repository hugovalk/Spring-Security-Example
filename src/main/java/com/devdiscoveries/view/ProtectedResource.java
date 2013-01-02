package com.devdiscoveries.view;

import javax.ws.rs.Path;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@Path("/protected")
public class ProtectedResource {

}
