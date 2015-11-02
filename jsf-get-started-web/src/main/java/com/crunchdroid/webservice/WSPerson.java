package com.crunchdroid.webservice;

import com.crunchdroid.entities.Person;
import com.crunchdroid.services.IPersonServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
@LocalBean
@Path(value = "/person")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class WSPerson {

    @EJB
    private IPersonServiceLocal personService;

    @GET
    public List<Person> findAll() {
        return personService.findAll();
    }

    @POST
    public void save(Person p) {
        personService.save(p);
    }

    @PUT
    public void update(Person p) {
        personService.update(p);
    }

    @GET
    @Path("{id}")
    public Person findById(@PathParam("id") Integer id) {
        return personService.findById(id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") Integer id) {
        personService.deleteById(id);
    }

}
