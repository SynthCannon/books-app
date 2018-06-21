package com.btn.service.repository;


import com.btn.domain.Author;
import com.btn.util.JSONUtil;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class AuthorDBRepository implements AuthorRepository {

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private JSONUtil util;

    @Override
    public String getAllAuthors() {
        Query query = manager.createQuery("Select a FROM Author a");
        Collection<Author> authors = (Collection<Author>) query.getResultList();
        return util.getJSONForObject(authors);
    }

    @Override
    @Transactional(REQUIRED)
    public String createAuthor(String author) {
        Author anAuthor = util.getObjectForJSON(author, Author.class);
        manager.persist(anAuthor);
        return "{\"message\": \"author has been successfully added\"}";
    }

    @Override
    @Transactional(REQUIRED)
    public String updateAuthor(Long id, String authorToUpdate) {
        Author updatedAuthor = util.getObjectForJSON(authorToUpdate, Author.class);
        Author authorFromDB = findAuthor(id);
        if (authorToUpdate != null) {
            authorFromDB = updatedAuthor;
            manager.merge(authorFromDB);
        }
        return "{\"message\": \"author successfully updated\"}";
    }

    @Override
    @Transactional(REQUIRED)
    public String deleteAuthor(Long id) {
        Author authorInDB = findAuthor(id);
        if (authorInDB != null) {
            manager.remove(authorInDB);
            return "{\"message\": \"author successfully deleted\"}";
        }
        return "{\"message\": \"author not found\"}";

    }

    protected Author findAuthor(Long id) {
        return manager.find(Author.class, id);
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void setUtil(JSONUtil util) {
        this.util = util;
    }
}