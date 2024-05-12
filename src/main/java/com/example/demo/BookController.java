package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books/")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("all")
    public Collection<Book> getAll(){
        return bookService.getBooks();
    }

    @GetMapping("get/{id}")
    public Book getByID(@PathVariable int id){
        return bookService.getBookByID(id);
    }

    @PostMapping("save")
    public Book insertBook(@RequestBody Book book){
        return  bookService.saveBook(book);
    }

    @PutMapping("update/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book){
        return  bookService.updateBook(id,book);
    }

    @DeleteMapping("delete/{id}")
    public Book deleteBook(@PathVariable int id){
        return bookService.deleteBookByID(id);
    }
}
