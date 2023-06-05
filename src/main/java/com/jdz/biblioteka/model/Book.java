package com.jdz.biblioteka.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name="book",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name="page_number", nullable = false)
    private int pageNumber;

    @Column(name="publication_year", nullable = false)
    private int publicationYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;
}
