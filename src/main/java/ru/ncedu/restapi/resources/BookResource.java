package ru.ncedu.restapi.resources;

import ru.ncedu.restapi.dao.BookDAO;
import ru.ncedu.restapi.models.Book;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookDAO bookDAO;

    @GET
    public Response getAll() {
        return Response.ok(bookDAO.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") Long id) {
        Book book = bookDAO.findById(id);
        return Response.ok(book).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Book book) {
        Book updateBook = bookDAO.findById(id);
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setDescription(book.getDescription());
        bookDAO.update(updateBook);
        return Response.ok().build();
    }

    @POST
    public Response create(Book book) {
        bookDAO.create(book);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Book getBook = bookDAO.findById(id);
        bookDAO.delete(getBook);
        return Response.ok().build();
    }
}