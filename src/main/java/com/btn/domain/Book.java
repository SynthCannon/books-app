package com.btn.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
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
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "BOOK_AUTHORS",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")
    )
    private Set<Author> authorsList = new HashSet<Author>();

    public Book(String bookTitle, String releaseYear, String genre) {
        this.bookTitle = bookTitle;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }
}
