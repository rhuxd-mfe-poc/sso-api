package org.rh.uxd.sso;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class User extends Application {
    private UserDataService dataService = UserDataService.getInstance();

    @GET
    public List<Contact> getUsers() {
        return dataService.getUserList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(Contact newUser) {
        return dataService.addUser(newUser);
    }

    @GET
    @Path("{id}")
    public Contact getUser(@PathParam("id") String id) {
        return dataService.getUserById(id);
    }

    @DELETE
    @Path("{id}")
    public String deleteUser(@PathParam("id") String id) { return dataService.deleteUser(id); }
}
