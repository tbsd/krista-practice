package org.acme.rest.json;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/persons")
public class PersonResource {
    @Inject
    @RestClient
    PersonService personService;


    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonResource() {
        persons.add(new Person("1", "Ivan Ivanovich", "user1", "user@mail.meh", new Address("Petrovskaya St.", "Moscow", "12345678"), "8-123-321-2211", "website.local", new Company("CompName", "phrase", "bs"), 1000));
        persons.add(new Person("2", "Petr Petrov", "user2", "userasdf@mail.meh", new Address("Kaya St.", "Moscow", "324444"), "8-333-331-3311", "asdfasdfite.local", new Company("CompName", "phrase", "bs"), 2000));
//        persons.add(new Person("2", "Vasyan Vashyanovich", new Address("Razumovskaya St.", "Yaroslavl", "12345632"), "8-151-000-2185"));
    }

    @GET
    public Set<Person> list() {
        return persons;
    }

    @POST
    public Set<Person> add(Person person) {
        persons.add(person);
        return persons;
    }

    @DELETE
    public Set<Person> delete(Person person) {
        persons.removeIf(existingPerson -> existingPerson.id.equals(person.id));
        return persons;
    }

    @GET
    @Path("/byid/{id}")
    public Person byId(@PathParam String id) {
        Optional<Person> result =  persons.stream().filter(p -> p.getId().equals(id)).findFirst();
        return result.orElse(new Person());
    }

    @GET
    @Path("/change/{id}")
    public Set<Person> byId(@PathParam String id, @QueryParam("cur") String newCurrency) throws IOException {
      Person person = null;
        for (Iterator<Person> it = persons.iterator(); it.hasNext(); ) {
            person = it.next();
            if (person.getId().equals(id)) {
                if (person.getCurrency() != newCurrency) {
                    double ratio = 1;
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://localhost:8000/" + person.getCurrency() + "/to/" + newCurrency)
                            .build();
                    Call call = client.newCall(request);
                    Response response = call.execute();
                    String responseText = response.body().string();
                    person.setSalary((int) (person.getSalary() / ratio));
                    person.setCurrency(newCurrency);
                }
            }
        }
        return personService.getAll();
    }

}