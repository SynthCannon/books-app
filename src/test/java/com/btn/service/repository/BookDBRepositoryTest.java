package com.btn.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.btn.domain.Book;
import com.btn.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class BookDBRepositoryTest {

    @InjectMocks
    private BookDBRepository repo;

    @Mock
    private EntityManager manager;

    @Mock
    private Query query;

    private JSONUtil util;

    private static final String MOCK_DATA_ARRAY = "[{\"bookTitle\":\"John\",\"releaseYear\":\"1991\",\"genre\":\"1234\"}]";

    private static final String MOCK_OBJECT = "{\"bookTitle\":\"Judd\",\"releaseYear\":\"1992\",\"genre\":\"1234\"}";

    @Before
    public void setup() {
        repo.setManager(manager);
        util = new JSONUtil();
        repo.setUtil(util);
    }

    @Test
    public void testGetAllBooks() {
        Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("John", "1991", "1234"));
        Mockito.when(query.getResultList()).thenReturn(books);
        Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllBooks());
    }

    @Test
    public void testCreateBook() {
        String reply = repo.createBook(MOCK_OBJECT);
        Assert.assertEquals("{\"message\": \"book has been successfully added\"}", reply);
    }

    @Test
    public void testUpdateBook() {
        String reply = repo.updateBook(1L, MOCK_OBJECT);
        Assert.assertEquals("{\"message\": \"book successfully updated\"}", reply);
    }

    @Test
    public void testDeleteBook() {
        String reply = repo.deleteBook(1L);
        Assert.assertEquals("{\"message\": \"book not found\"}", reply);
    }

}


