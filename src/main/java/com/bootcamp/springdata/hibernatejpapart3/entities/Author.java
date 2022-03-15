package com.bootcamp.springdata.hibernatejpapart3.entities;

import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Embedded
    Address address;

    //many to many
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authors_subjects",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
    private List<Subject> subjects;

    //one to one
    @OneToOne(mappedBy = "author")
    private Book books;

    //one to many - Unidirectional - author writes many book, if there is an author then there will book
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private List<Book> Books;

    public void setBooks(List<Book> books) {
        Books = books;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
