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
    public List<Contact> getCustomers() {
        return dataService.getCustomerList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createCustomer(Contact newCustomer) {
        return dataService.addCustomer(newCustomer);
    }

    @GET
    @Path("{id}")
    public Contact getCustomer(@PathParam("id") String id) {
        return dataService.getCustomerById(id);
    }

    @DELETE
    @Path("{id}")
    public String delete(@PathParam("id") String id) { return dataService.deleteCustomer(id); }
}
