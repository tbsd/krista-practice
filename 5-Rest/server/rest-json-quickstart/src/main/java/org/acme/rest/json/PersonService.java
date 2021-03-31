package org.acme.rest.json;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

@RegisterRestClient(configKey = "users-api")
public interface PersonService {

    @GET
    @Path("/users/{id}")
    Set<Person> getById(@PathParam String id);

    @GET
    @Path("/users/")
    Set<Person> getAll();
}