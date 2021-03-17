package org.example;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Serializer ser = new Serializer();
        Person person = new Person("Asdf", "Meh",
                new Address("Krasnaya ploshad", "Moskow", 111111),
                new ArrayList<PhoneNumber>(Arrays.asList(new PhoneNumber("7-356-322-1234"))));
        String data = ser.toJson(person);
        System.out.println( data );
        Person deseriallized = (Person) ser.fromJson(data, Person.class);

        if (deseriallized.equals(person) )
            System.out.println("ok");
    }

}
