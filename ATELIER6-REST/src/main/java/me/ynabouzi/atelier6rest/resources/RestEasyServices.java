package me.ynabouzi.atelier6rest.resources;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/restapi")
public class RestEasyServices extends Application {

    private Set < Object > singletons = new HashSet < Object > ();

    public RestEasyServices() {
        singletons.add(new HelloWorldResource());
    }

    @Override
    public Set < Object > getSingletons() {
        return singletons;
    }
}