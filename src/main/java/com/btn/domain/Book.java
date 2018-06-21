package com.btn.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Size(min = 1, max = 255)
    private String bookTitle;
    @Size(min = 1, max = 5)
    private String releaseYear;
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
