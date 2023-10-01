package at.htlleonding.gettingstarted;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "test", defaultValue = "Servus")
    String test;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return test + " 4chif!";
    }
}
