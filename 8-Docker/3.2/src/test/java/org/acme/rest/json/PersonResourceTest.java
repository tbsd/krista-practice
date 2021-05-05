package org.acme.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class PersonResourceTest {
    OkHttpClient client = new OkHttpClient();

    @Test
    public void testGetList() throws IOException {
        Request request = new Request.Builder()
                .url("http://localhost:8080/persons")
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String responseText = response.body().string();
        String data = "[{\"firstName\":\"Ivan\",\"lastName\":\"Ivanovich\",\"address\":{\"streetAddress\":\"Petrovskaya St.\",\"city\":\"Moscow\",\"postalCode\":12345678},\"phoneNumbers\":[{\"phone\":\"8-123-321-2211\"}]},{\"firstName\":\"Vasyan\",\"lastName\":\"Vashyanovich\",\"address\":{\"streetAddress\":\"Razumovskaya St.\",\"city\":\"Yaroslavl\",\"postalCode\":12345632},\"phoneNumbers\":[{\"phone\":\"8-151-000-2185\"}]}]";
        assertEquals(data, responseText);
    }

}