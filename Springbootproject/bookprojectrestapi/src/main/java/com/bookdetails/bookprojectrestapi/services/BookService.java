package com.bookdetails.bookprojectrestapi.services;

import java.util.List;


import com.bookdetails.bookprojectrestapi.Dao.BookRepository;
import com.bookdetails.bookprojectrestapi.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BookService {
     @Autowired
     private BookRepository bookRepository;


  //  private static List<Book> list=new ArrayList<>();
   // static{
      //  list.add(new Book(123, "Java complete Reference", "ABC"));
       //  list.add(new Book(125, "Head First To Java", "XYZ"));
       //  list.add(new Book(128, "Think in Java", "LMN"));
  //  }
    //get all books
    public List<Book> getallBooks()
    {
         List<Book> list=(List<Book>)this.bookRepository.findAll();
         return list;
    }
    
    //get single book by id
    public Book getBookById(int id)
    {
         Book book=null;
         try{
               book=this.bookRepository.findById(id);
         }catch(Exception e){
             e.printStackTrace();
         }
        // book= list.stream().filter(e->e.getId()==id).findFirst().get();
         return book;
    }

    //adding the book
    public Book addBook(Book b)
    {
        Book result=bookRepository.save(b);
         return result;
    }

    //delete the book
    public void deleteBook(int bid)
    {
        // list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteAll();
    }

    //update the book
    public void updateBook(Book book,int bookId)
    {
         //list=list.stream().map(b->{
           //   if(b.getId()==bookId)
             // {
               //    b.setTitle(book.getTitle());
                 //  b.setAuthor(book.getAuthor());
              //}
              //return b;
        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }
} 
