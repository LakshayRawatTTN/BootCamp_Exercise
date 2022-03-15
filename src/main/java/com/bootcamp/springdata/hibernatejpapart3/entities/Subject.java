package com.bootcamp.springdata.hibernatejpapart3.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String subjectname;

    public Subject() {
    }

    public Subject(String subjectname) {
        this.subjectname = subjectname;
    }

    @ManyToMany(mappedBy = "subjects")
    private List<Author> authors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }
}
