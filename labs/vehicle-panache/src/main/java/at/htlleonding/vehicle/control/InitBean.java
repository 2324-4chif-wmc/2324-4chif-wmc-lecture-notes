package at.htlleonding.vehicle.control;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class InitBean {

    @ConfigProperty(name = "my.personal.property", defaultValue = "xyz")
    String myProperty;

    void init(@Observes StartupEvent event) {
        Log.error(myProperty);
    }


}
