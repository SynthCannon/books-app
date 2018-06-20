package com.btn.domain;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @OneToMany(mappedBy = "BOOK")
    private Long id;
    @ManyToMany(mappedBy="AUTHOR")
    private List<Book> books;
    @ManyToOne
    private Book book;

}
