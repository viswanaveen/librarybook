package com.naveen.librarybook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "library")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Library(String name) {
        this.name = name;
    }

    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Book> books;
}
