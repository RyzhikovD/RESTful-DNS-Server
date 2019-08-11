package ru.ncedu.restapi.dao;

import ru.ncedu.restapi.models.Book;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public void create(Book book) {
        em.persist(book);
    }

    public void delete(Book book) {
        if (!em.contains(book)) {
            book = em.merge(book);
        }
        em.remove(book);
    }
}