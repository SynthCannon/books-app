package com.btn.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Genre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @OneToMany(mappedBy = "BOOK")
    private Long id;
    @Size(min = 2, max = 80)
    private String genre;


}
