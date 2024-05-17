package com.bookdetails.bookprojectrestapi.Dao;

import com.bookdetails.bookprojectrestapi.entity.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
