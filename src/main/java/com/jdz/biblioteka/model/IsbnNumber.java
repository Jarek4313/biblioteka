package com.jdz.biblioteka.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name="isbn_number",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"isbn"})}
)
public class IsbnNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="isbn", nullable = false)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;
}
