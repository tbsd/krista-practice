package org.acme.rest.json;

import java.util.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/persons")
public class PersonResource {

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonResource() {
        persons.add(new Person("Ivan", "Ivanovich", new Address("Petrovskaya St.", "Moscow", 12345678), new ArrayList<PhoneNumber>(Arrays.asList(new PhoneNumber("8-123-321-2211")))));
        persons.add(new Person("Vasyan", "Vashyanovich", new Address("Razumovskaya St.", "Yaroslavl", 12345632), new ArrayList<PhoneNumber>(Arrays.asList(new PhoneNumber("8-151-000-2185")))));
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
        persons.removeIf(existingPerson -> existingPerson.firstName.contentEquals(person.firstName) && existingPerson.lastName.contentEquals(person.lastName));
        return persons;
    }
}