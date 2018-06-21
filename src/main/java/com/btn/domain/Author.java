package com.btn.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    @Id
    private Long id;
    @Column(nullable = false)
    @Size(min = 1, max = 255)
    private String name;

    @ManyToMany(mappedBy="authorsList")
    private Set<Book> booksList;

}
