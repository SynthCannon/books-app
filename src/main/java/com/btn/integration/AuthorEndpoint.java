package com.btn.integration;

import com.btn.service.business.AuthorService;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/author")
public class AuthorEndpoint {

    private static final Logger LOGGER = Logger.getLogger(AuthorEndpoint.class);

    @Inject
    private AuthorService service;

    @Path("/json")
    @GET
    @Produces({ "application/json" })
    public String getAllAuthors() {
        LOGGER.info("AuthorEndpoint + getAllAuthors");
        return service.getAllAuthors();
    }

    @Path("/json")
    @POST
    @Produces({ "application/json" })
    public String addAuthor(String author) {
        LOGGER.info("AuthorEndpoint + addAuthor");
        return service.addAuthor(author);
    }

    @Path("/json/{id}")
    @PUT
    @Produces({ "application/json" })
    public String updateAuthor(@PathParam("id") Long id, String author) {
        LOGGER.info("AuthorEndpoint + updateAuthor");
        return service.updateAuthor(id, author);
    }

    @Path("/json/{id}")
    @DELETE
    @Produces({ "application/json" })
    public String deleteAuthor(@PathParam("id") Long id) {
        LOGGER.info("AuthorEndpoint + deleteAuthor");
        return service.deleteAuthor(id);

    }

    public void setService(AuthorService service) {
        LOGGER.info("AuthorEndpoint + setService");
        this.service = service;
    }
}

