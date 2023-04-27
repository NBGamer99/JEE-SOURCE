package me.ynabouzi.endpoint;

import me.ynabouzi.InputSOATest;
import me.ynabouzi.ObjectFactory;
import me.ynabouzi.OutputSOATest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WebServiceEndpoint {

    private static final String NAMESPACE_URI = "http://ynabouzi.me";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
    @ResponsePayload
    public OutputSOATest hello(@RequestPayload InputSOATest request) {

        String outputString = "Hello " + request.getTest() + "!";

        ObjectFactory factory = new ObjectFactory();
        OutputSOATest response = factory.createOutputSOATest();
        response.setResult(outputString);

        return response;
    }
}

