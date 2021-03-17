package org.example;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SerializerTest {
    private Serializer serializer = new Serializer();

    @Test
    public void shouldSerializeToJson() {
        Person person = new Person("Asdf", "Meh",
                new Address("Krasnaya ploshad", "Moskow", 111111),
                new ArrayList<PhoneNumber>(Arrays.asList(new PhoneNumber("7-356-322-1234"))));
        String data = serializer.toJson(person);
        Person deserialized = (Person) serializer.fromJson(data, Person.class);
        assertEquals(person, deserialized);
    }

    @Test
    public void shouldDeserializeFromJson() {
        Person person = new Person("Asdf", "Meh",
                new Address("Krasnaya ploshad", "Moskow", 111111),
                new ArrayList<PhoneNumber>(Arrays.asList(new PhoneNumber("7-356-322-1234"))));
        String serialized = "{\"firstName\":\"Asdf\",\"lastName\":\"Meh\",\"address\":{\"streetAddress\":\"Krasnaya ploshad\",\"city\":\"Moskow\",\"postalCode\":111111},\"phoneNumbers\":[{\"phone\":\"7-356-322-1234\"}]}";
        Person deserialized = (Person) serializer.fromJson(serialized, Person.class);
        String serializedAgain = serializer.toJson(deserialized);
        assertEquals(serialized, serializedAgain);
    }
}
