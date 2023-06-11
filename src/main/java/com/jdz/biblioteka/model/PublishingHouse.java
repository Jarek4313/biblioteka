package com.jdz.biblioteka.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(
        name="publishing_house",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(
            mappedBy = "publishingHouse",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
//            orphanRemoval = true
    )
    private Set<Book> listOfBooks;
}
