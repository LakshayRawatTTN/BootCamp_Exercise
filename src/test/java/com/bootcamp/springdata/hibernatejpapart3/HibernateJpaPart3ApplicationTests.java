package com.bootcamp.springdata.hibernatejpapart3;

import com.bootcamp.springdata.hibernatejpapart3.entities.Address;
import com.bootcamp.springdata.hibernatejpapart3.entities.Author;
import com.bootcamp.springdata.hibernatejpapart3.entities.Book;
import com.bootcamp.springdata.hibernatejpapart3.entities.Subject;
import com.bootcamp.springdata.hibernatejpapart3.repos.AuthorRepository;
import com.bootcamp.springdata.hibernatejpapart3.repos.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class HibernateJpaPart3ApplicationTests {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAdd() {
        Author author1 = new Author();
        author1.setName("Lakshay Rawat");
        Address address = new Address();
        address.setStreetNumber(2);
        address.setLocation("Dilshad Garden");
        address.setStreet("pocket-L");
        author1.setAddress(address);
        List<Subject> list = Arrays.asList(new Subject("java"),
                new Subject("python"), new Subject("c++"));
        author1.setSubjects(list);


        authorRepository.save(author1);
    }

    @Test
    public void testOnetoOneBook_Author() {
        Book java = new Book();
        java.setBookName("java head first");
        Author author = new Author();
        author.setName("Sumeet naveen");
        Address address = new Address();
        address.setStreetNumber(2);
        address.setLocation("Bhalwani");
        address.setStreet("TTNpura");
        author.setAddress(address);
        java.setAuthor(author);
        bookRepository.save(java);
    }

    @Test
    public void testOneToManyUniDirectional() {
        Author author = new Author();
        author.setName("Ashish Gupta");
        Address address = new Address();
        address.setStreet("Vegas");
        address.setStreetNumber(101);
        address.setLocation("Dwarka");
        author.setAddress(address);
        List<Book> list = new ArrayList<Book>();
        author.setBooks(Arrays.asList(new Book("Java"), new Book("TTN"), new Book("NTT")));
        authorRepository.save(author);
    }

}
