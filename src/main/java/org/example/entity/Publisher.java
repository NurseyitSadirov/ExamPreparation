package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(generator = "publisher_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "publisher_gen",sequenceName = "publisher_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @ManyToMany
    private List<Author> author;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
