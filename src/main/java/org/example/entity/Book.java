package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Genre;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "books_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "books_gen",sequenceName = "books_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    @Column(name = "publisher_year")
    private LocalDate publisherYear;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;

    public Book(String name, String country, LocalDate publisherYear, int price, Genre genre) {
        this.name = name;
        this.country = country;
        this.publisherYear = publisherYear;
        this.price = price;
        this.genre = genre;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", publisherYear=" + publisherYear +
                ", price=" + price +
                ", genre=" + genre +
                '}';
    }
}
