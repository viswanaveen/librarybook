package com.naveen.librarybook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity

@Data
@ToString(exclude = "library")
@EqualsAndHashCode(exclude = "library")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    public Book(int id, String name, String author, String language, String isbn, String publisher, Long length, Double weight, Library library) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.language = language;
        this.isbn = isbn;
        this.publisher = publisher;
        this.length = length;
        Weight = weight;
        this.library = library;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private @NonNull String name;
    private @NonNull String author;
    private @NonNull String language;
    private @NonNull String isbn;
 /*   @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss z")
    private Date releaseDate;*/
    private @NonNull String publisher;
    private @NonNull Long length;
    private @NonNull Double Weight;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id" )
    private Library library;

}
