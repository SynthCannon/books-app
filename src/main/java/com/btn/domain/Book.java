package com.btn.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Year;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Size(min = 2, max = 80)
    private String bookTitle;
    @Column
    private Year releaseYear;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_GENRE")
    private Long genreID;
    @ManyToMany
    @JoinTable( name = "GS_BOOK_AUTHOR",
            joinColumns = @JoinColumn(name = "CD_BOOK"),
            inverseJoinColumns = @JoinColumn(name = "CD_AUTHOR") )
    private List<Author> authorsList;

    public Book() {}

    public Book(String bookTitle, Year releaseYear, Long genreID, List<Author> authorsList) {
        this.bookTitle = bookTitle;
        this.releaseYear = releaseYear;
        this.genreID = genreID;
        this.authorsList = authorsList;
    }
}
