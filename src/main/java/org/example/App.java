package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.enums.Gender;
import org.example.enums.Genre;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.ReaderService;
import org.example.service.impl.AuthorServiceImpl;
import org.example.service.impl.BookServiceImpl;
import org.example.service.impl.PublisherServiceImpl;
import org.example.service.impl.ReaderServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Publisher publisher = new Publisher("Sanjar", "England");
        PublisherServiceImpl publisherService = new PublisherServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        while (true) {
            System.out.println("""
                    1.Author
                    2.Book
                    3.Publisher
                    4.Reader""");
            int a = new Scanner(System.in).nextInt();
            switch (a) {
                case 1 -> {
                    System.out.println("""
                            1.save publishers
                            2.get publishers by id
                            3.get all publishers
                            4.update publishers
                            5.delete publishers by  name""");
                    int b = new Scanner(System.in).nextInt();
                    switch (b) {
                        case 1 -> System.out.println(publisherService.savePublisher(publisher));
                        case 2 -> System.out.println(publisherService.getPublisherById(1L));
                        case 3 -> System.out.println(publisherService.getPublishers());
                        case 4 -> System.out.println(publisherService.deletePublisherByName("Nurseyit"));
                    }
                }
                case 2 -> {
                    System.out.println("""
                            1.save book
                            2.update book author
                            3.get book and publisher book id
                            4.delete book by author id""");
                    int c = new Scanner(System.in).nextInt();
                    switch (c) {
                        case 1 ->
                                bookService.saveBook(new Book("Ak keme", "Kyrgyzstan", LocalDate.of(2003, 11, 22), 2800, Genre.DRAMA));
                        case 2 ->
                                bookService.updateBookAuthor(1L, new Author("Chyngyz", "Aitmatov", "chyngyz@gmail.com", LocalDate.of(1928, 12, 12), "Kyrgyzstan", Gender.MALE));
                        case 3 -> System.out.println(bookService.getBookAndPublisherBookId());
                        case 4 -> bookService.deleteBookByAuthorId(1L);
                    }
                }
            }
        }
    }
}
