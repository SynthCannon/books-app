package com.btn.integration;

import com.btn.service.business.BookService;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/book")
public class BookEndpoint {

    private static final Logger LOGGER = Logger.getLogger(BookEndpoint.class);

    @Inject
    private BookService service;

    @Path("/json")
    @GET
    @Produces({ "application/json" })
    public String getAllBooks() {
        LOGGER.info("BookEndpoint + getAllBooks");
        return service.getAllBooks();
    }

    @Path("/json")
    @POST
    @Produces({ "application/json" })
    public String addBook(String book) {
        LOGGER.info("BookEndpoint + addBook");
        return service.addBook(book);
    }

    @Path("/json/{id}")
    @PUT
    @Produces({ "application/json" })
    public String updateBook(@PathParam("id") Long id, String book) {
        LOGGER.info("BookEndpoint + updateBook");
        return service.updateBook(id, book);
    }

    @Path("/json/{id}")
    @DELETE
    @Produces({ "application/json" })
    public String deleteBook(@PathParam("id") Long id) {
        LOGGER.info("BookEndpoint + deleteBook");
        return service.deleteBook(id);

    }

    public void setService(BookService service) {
        LOGGER.info("BookEndpoint + setService");
        this.service = service;
    }
}
