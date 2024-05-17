package com.bookdetails.bookprojectrestapi.controller;

import java.util.List;


import com.bookdetails.bookprojectrestapi.entity.Book;
import com.bookdetails.bookprojectrestapi.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> list=bookService.getallBooks();
       // Book book=new Book();
       if(list.size()<=0)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
       return bookService.getBookById(id);
    } 

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        Book b=this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId)
    {
        this.bookService.deleteBook(bookId);
    }
    
    @PutMapping("books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
    {
        this.bookService.updateBook(book,bookId);
        return book;
    }
} 
