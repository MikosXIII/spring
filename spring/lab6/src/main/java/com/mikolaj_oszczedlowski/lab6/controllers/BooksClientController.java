package com.mikolaj_oszczedlowski.lab6.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mikolaj_oszczedlowski.lab6.models.Book;

@Controller
@RequestMapping("/books")
public class BooksClientController {

    @GetMapping("/list")
    public ModelAndView BooksGet(){

        String uri = "http://localhost:8080/books/api/list";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Book[]> response = restTemplate.getForEntity(uri, Book[].class);
        Book[] arr = response.getBody();
        List<Book>  list = Arrays.asList(arr);
        System.out.println("List of Books: " + list);
        return new ModelAndView("allBooks", "bookList", list);
    } 
    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public ModelAndView addNewBook() {

        Book book = new Book();
        return new ModelAndView("newBook", "form", book);

    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
public ModelAndView BooksSave(@ModelAttribute("form") Book book) {
    System.out.println("BooksSave method is called. Book title: " + book.getTitle());
    System.out.println("Book ID: " + book.getId());

    String uri = "http://localhost:8080/books/api/save";
    RestTemplate restTemplate = new RestTemplate();

    if (book.getId() != 0) {
        System.out.println("Updating existing book...");
        String updateUri = "http://localhost:8080/books/api/save/{id}";
        restTemplate.put(updateUri, book, book.getId());
    } else {
        System.out.println("Creating new book...");
        restTemplate.postForObject(uri, book, Book.class);
    }

    return new ModelAndView("redirect:/books/list");
}

    @GetMapping("/edit/{id}")
    public ModelAndView BooksEdit(@PathVariable("id") String id){

        String uri = "http://localhost:8080/books/api/edit/{id}";
        RestTemplate restTemplate = new RestTemplate();
        
        Map<String, String> params = new HashMap<String, String> ();
        params.put("id", id);
        Book book = restTemplate.getForObject(uri, Book.class, params);
        return new ModelAndView("editBook", "form", book);
    } 

    @GetMapping("/delete/{id}")
    public ModelAndView BooksDelete(@PathVariable("id") String id){

        String uri = "http://localhost:8080/books/api/delete/{id}";
        RestTemplate restTemplate = new RestTemplate();
        
        Map<String, String> params = new HashMap<String, String> ();
        params.put("id", id);
        restTemplate.delete(uri, params);
        return new ModelAndView("redirect:/books/list");
    }
}