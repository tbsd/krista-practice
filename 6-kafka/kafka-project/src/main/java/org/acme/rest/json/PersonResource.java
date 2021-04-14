package org.acme.rest.json;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.*;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/persons")
public class PersonResource {
    @Inject
    private PersonProducer personProducer;


    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonResource() {
//        persons.add(new Person("1", "Ivan Ivanovich", new Address("Petrovskaya St.", "Moscow", "12345678"), "8-123-321-2211"));
//        persons.add(new Person("2", "Vasyan Vashyanovich", new Address("Razumovskaya St.", "Yaroslavl", "12345632"), "8-151-000-2185"));
    }


    @POST
    public void add(Person person) {
        personProducer.sendPersonToKafka(person);
    }

}