package ru.tomlott.demo.book;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
            name="book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private int year;
    private String plot;

    public Book() {

    }
    public Book(Long id, String name, String author, String publisher, int year, String plot) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.plot = plot;
    }
    public Book(String name, String author, String publisher, int year, String plot) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.plot = plot;
    }





    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
