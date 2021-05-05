package org.acme.rest.json;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.*;

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
//        persons.add(new Person("1", "Ivan Ivanovich", new Address("Petrovskaya St.", "Moscow", "12345678"), "8-123-321-2211"));
//        persons.add(new Person("2", "Vasyan Vashyanovich", new Address("Razumovskaya St.", "Yaroslavl", "12345632"), "8-151-000-2185"));
    }

    @GET
    public Set<Person> list() {
        return personService.getAll();
    }

    @POST
    public Set<Person> add(Person person) {
        persons.add(person);
        return persons;
    }

    @DELETE
    public Set<Person> delete(Person person) {
        persons.removeIf(existingPerson -> existingPerson.id == person.id);
        return persons;
    }

    @GET
    @Path("/byid/{id}")
    public Set<Person> byId(@PathParam String id) {
        return personService.getById(id);
    }

    @GET
    @Path("/change/{id}")
    public Set<Person> byId(@PathParam String id, @QueryParam("cur") String newCurrency) {
      Person person = null;
        for (Iterator<Person> it = persons.iterator(); it.hasNext(); ) {
            person = it.next();
            if (person.getId() == id) {
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