package com.bootcamp.springdata.hibernatejpapart3.repos;

import com.bootcamp.springdata.hibernatejpapart3.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
