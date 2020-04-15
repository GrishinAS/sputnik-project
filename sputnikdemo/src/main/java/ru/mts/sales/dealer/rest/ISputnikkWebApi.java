package ru.mts.sales.dealer.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/sputnik")
//@Component(service = SputnikWebApi.class, property = { "osgi.jaxrs.resource=true" })
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public interface ISputnikkWebApi {
  @POST
  @Path("/complect")
  String sellSTVComplect( @Context HttpHeaders headers);
}
