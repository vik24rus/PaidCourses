package app.dao;

import app.domain.Departments;

import java.util.List;

public interface DepartmentsDao {

    Author getById(long id);


    void insert(Author author);


    List<Author> getAll(); //TODO как использовать списки в dao?!


    void update(Author author);


    void deleteById(long id);


    void deleteAll();

}
