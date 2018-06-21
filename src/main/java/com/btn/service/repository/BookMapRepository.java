//package com.btn.service.repository;
//
//
//import com.btn.domain.Book;
//import com.btn.util.JSONUtil;
//import org.apache.log4j.Logger;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.inject.Alternative;
//import javax.inject.Inject;
//import java.util.*;
//
//
//@ApplicationScoped
//@Alternative
//public class BookMapRepository implements BookRepository{
//    private static final Logger LOGGER = Logger.getLogger(BookRepository.class);
//
//    private final Long INITIAL_COUNT = 1L;
//    private Map<Long, Book> bookMap;
//    private Long ID;
//
//    @Inject
//    private JSONUtil util;
//
//    public BookMapRepository() {
//        this.bookMap = new HashMap<Long, Book>();
//        ID = INITIAL_COUNT;
//        initBookMap();
//    }
//
//    @Override
//    public String getAllBooks() {
//        LOGGER.info("BookMapRepository + getAllBooks");
//        return util.getJSONForObject(bookMap.values());
//    }
//
//    @Override
//    public String createBook(String book) {
//        LOGGER.info("BookMapRepository + createBook");
//        ID++;
//        Book newBook = util.getObjectForJSON(book, Book.class);
//        bookMap.put(ID, newBook);
//        return book;
//    }
//
//    @Override
//    public String updateBook(Long id, String bookToUpdate) {
//        Book newBook = util.getObjectForJSON(bookToUpdate, Book.class);
//        bookMap.put(id, newBook);
//        return bookToUpdate;
//    }
//    @Override
//    public String deleteBook(Long id) {
//        LOGGER.info("BookMapRepository + deleteBook");
//        bookMap.remove(id);
//        return "{\"message\": \"accout sucessfully removed\"}";
//    }
//
//    private void initBookMap() {
//        LOGGER.info("BookMapRepository + initBookMap");
//        List<String> authorsList = new ArrayList<<>>();
//        authorsList.add("Edgar Allan Poe");
//        authorsList.add("Oscar Wilde");
//        Book book = new Book("Joe", 1999, "mystery", authorsList);
//        bookMap.put(1L, book);
//    }
//
//}
