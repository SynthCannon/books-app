package com.btn.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.btn.service.business.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookEndpointTest {

    private static final String MOCK_VALUE2 = "test_value_2";

    private static final String MOCK_VALUE = "test_value";

    @InjectMocks
    private BookEndpoint endpoint;

    @Mock
    private BookService service;

    @Before
    public void setup() {
        endpoint.setService(service);
    }

    @Test
    public void testGetAllBooks() {
        Mockito.when(service.getAllBooks()).thenReturn(MOCK_VALUE);
        Assert.assertEquals(MOCK_VALUE, endpoint.getAllBooks());
    }

    @Test
    public void testCreateBook() {
        Mockito.when(service.addBook(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
        Assert.assertEquals(MOCK_VALUE, endpoint.addBook(MOCK_VALUE2));
        Mockito.verify(service).addBook(MOCK_VALUE2);
    }

    @Test
    public void testUpdateBook() {
        Mockito.when(service.updateBook(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
        Assert.assertEquals(MOCK_VALUE, endpoint.updateBook(1L, MOCK_VALUE2));
        Mockito.verify(service).updateBook(1L, MOCK_VALUE2);
    }

    @Test
    public void testDeleteBook() {
        Mockito.when(service.deleteBook(1L)).thenReturn(MOCK_VALUE);
        Assert.assertEquals(MOCK_VALUE, endpoint.deleteBook(1L));
        Mockito.verify(service).deleteBook(1L);
    }
}
