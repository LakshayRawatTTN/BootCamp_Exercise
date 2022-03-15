package com.bootcamp.springdata.hibernatejpapart3.repos;

import com.bootcamp.springdata.hibernatejpapart3.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
