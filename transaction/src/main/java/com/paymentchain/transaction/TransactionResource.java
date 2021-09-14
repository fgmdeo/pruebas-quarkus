package com.paymentchain.transaction;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionResource {

    @Inject 
    TransactionService service;



    @GET
    public List<Transaction> findAll(@DefaultValue("reference") @QueryParam("reference") String reference, @DefaultValue("ibanAccount") @QueryParam("ibanAccount") String ibanAccount) {
        
        if ((reference.equals("reference") && ibanAccount.equals("ibanAccount")))
            return service.listAll();
        else
            return service.findAllByReferenceIban(reference,ibanAccount);
         
    }

    @GET
    @Path("/{id}")
    public Transaction find(@PathParam("id") long id) {
        return service.findById(id);
    }

    @POST
    @Transactional
    public Transaction save(Transaction newTransaction) {
        return service.save(newTransaction);
    }

    @PUT
    @Transactional
    public void update( Transaction transtaction) {
       service.update(transtaction);
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Boolean delete(@PathParam("id") long id) {
        if (!service.delete(id)) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return true;
    }
}
