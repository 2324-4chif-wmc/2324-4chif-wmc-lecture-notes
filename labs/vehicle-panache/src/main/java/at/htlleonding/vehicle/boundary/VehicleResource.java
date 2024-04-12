package at.htlleonding.vehicle.boundary;

import at.htlleonding.vehicle.control.VehicleRepository;
import at.htlleonding.vehicle.entity.Vehicle;
import at.htlleonding.vehicle.entity.VehicleDto;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Path("/vehicle")
public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

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
    public List<VehicleDto> findAll() {
        //var comparator = new VehicleComparator();

        return vehicleRepository
                .listAll()
                .stream()
                .map(Vehicle::toDto)
                .sorted((l, r) -> l.brand().compareTo(r.brand()))
                .toList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/{brand}")
    public Response findFirstOfBrand(@PathParam("brand") String brand) {
        var optionalCar =  vehicleRepository
                .listAll()
                .stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .findFirst();

        var response = optionalCar.isPresent() ?
                Response.ok(optionalCar.get().toDto()) :
                Response.status(Response.Status.NOT_FOUND);

        return response.build();
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

class VehicleComparator {
    public int compare(VehicleDto v1, VehicleDto v2) {
        return v1.brand().compareTo(v2.brand());
    }
}