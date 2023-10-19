package at.htlleonding.vehicle.boundary;

import at.htlleonding.vehicle.entity.Vehicle;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/vehicle")
public class VehicleResource {

    @GET
    @Produces({
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML
    })
    @Path("{id}")
    public Vehicle find(@PathParam("id") long id) {
        return new Vehicle("Opel " + id, "Commodore");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> findAll() {
        List<Vehicle> all = new ArrayList<>();
        all.add(new Vehicle("Opel", "Senator"));
        all.add(new Vehicle("Opel", "Kapitän"));
        return all;
    }

    @GET
    @Path("json")

    public JsonObject getJsonObject() {
        var myJsonObject = Json.createObjectBuilder()
                .add("firstName", "Susi")
                .add("lastName", "Huber")
                .build();
        return myJsonObject;
    }

    @GET
    @Path("response")
    public Response getResponse() {
        return Response
                .ok(new Vehicle("Opel", "Senator"))
                .header("MY-SUPER-HEADER", "super")
                .build();
    }

    @POST
    public Response createVehicle(Vehicle vehicle, @Context UriInfo uriInfo) {
        System.out.println(vehicle);

        URI uri = uriInfo.getAbsolutePathBuilder().path("23").build();

//        return Response
//                .ok(Json.createObjectBuilder()
//                        .add("a","b")
//                        .build()
//                )
//                .build();

        return Response
                .created(uri)
                .build();
    }

}
