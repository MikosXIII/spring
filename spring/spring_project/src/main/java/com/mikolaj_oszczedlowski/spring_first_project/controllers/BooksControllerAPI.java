package com.mikolaj_oszczedlowski.spring_first_project.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.mikolaj_oszczedlowski.spring_first_project.models.Book;
import com.mikolaj_oszczedlowski.spring_first_project.data.BooksRepository;

@RestController
@RequestMapping("/books/api")
public class BooksControllerAPI {

    //@Autowired
    private BooksRepository booksData;

    public BooksControllerAPI(BooksRepository repo) {
        super();
        booksData = repo;
    }

    @GetMapping(value = "/list")
    public List<Book> books() {
        List<Book> allBooks = booksData.findAll();
        return allBooks;
    }

    @PostMapping(value = "/save")
    public Book save(@RequestBody Book book) {
        if (book != null) {
            booksData.save(book);
        }
        return book;
    }

    @GetMapping(value = "/edit/{id}")
    public Book editBook(@PathVariable long id) {
        Optional<Book> book = booksData.findById(id);

        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteBook(@PathVariable long id) {
        Optional<Book> book = booksData.findById(id);

        if (book.isPresent()) {
            booksData.delete(book.get());
            return true;
        }

        return false;
    }
}
