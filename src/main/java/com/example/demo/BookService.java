package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {
    //Dummy DB
    private Map<Integer,Book> books = new ConcurrentHashMap<>();
    // Auto ID
    private AtomicInteger autoID = new AtomicInteger();

    //Get book by id
    public Book getBookByID(int id){
        return books.get(id);
    }

    //Get All Books
    public Collection<Book> getBooks(){
        return books.values();
    }

    //Save Book
    public Book saveBook(Book newBook){
        int id =  autoID.incrementAndGet();
        newBook.setId(id);
        books.put(id,newBook);
        return newBook;
    }

    // Update
    public  Book updateBook(int id,Book updatedBook){
        if (books.containsKey(id)){
            Book oldBook = getBookByID(id);
            oldBook.setAuthor(updatedBook.getAuthor());
            oldBook.setTitle(updatedBook.getTitle());
            books.put(id,oldBook);
            return oldBook;
        }else {
            return null;
        }
    }
    public Book deleteBookByID(int id){
        return books.remove(id);
    }
}
