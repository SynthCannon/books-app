package com.btn.service.business;

import com.btn.service.repository.AuthorRepository;
import org.apache.log4j.Logger;

import javax.inject.Inject;

public class AuthorServiceImpl implements AuthorService {

    private static final Logger LOGGER = Logger.getLogger(AuthorService.class);

    @Inject
    private AuthorRepository repo;

    public String getAllAuthors() {
        LOGGER.info("In AuthorServiceImpl getAllAuthors ");
        return repo.getAllAuthors();
    }

    @Override
    public String addAuthor(String author) {
        return repo.createAuthor(author);
    }

    @Override
    public String updateAuthor(Long id, String author) {
        return repo.updateAuthor(id, author);
    }

    @Override
    public String deleteAuthor(Long id) {
        return repo.deleteAuthor(id);

    }

    public void setRepo(AuthorRepository repo) {
        this.repo = repo;
    }
}
