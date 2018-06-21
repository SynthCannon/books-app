package com.btn.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    @Size(min = 1, max = 255)
    private String bookTitle;
    @Column(nullable = false)
    @Size(min = 1, max = 4)
    private String releaseYear;
    @Column(nullable = false)
    @Size(min = 1, max = 255)
    private String genre;
//    @Column
//    private List<String> authorsList;

    public Book(String bookTitle, String releaseYear, String genre){//, List<String> authorsList) {
        this.bookTitle = bookTitle;
        this.releaseYear = releaseYear;
        this.genre = genre;
        //this.authorsList = authorsList;
    }
}
