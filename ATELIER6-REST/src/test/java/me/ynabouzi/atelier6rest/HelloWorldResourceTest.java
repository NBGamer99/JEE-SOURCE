package me.ynabouzi.atelier6rest;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.jupiter.api.Test;

public class HelloWorldResourceTest {

    private static final String FULL_PATH = "http://localhost:8080/RestFul_Hello_world_war_exploded/restapi/hello";

    @Test
    public void testHelloWorld() {

        final ResteasyClient client = new ResteasyClientBuilder().build();
        final ResteasyWebTarget target = client.target(FULL_PATH);
        String response = target.request().get(String.class);
        System.out.println(response);
    }
}
