package com.mikolaj_oszczedlowski.spring_first_project.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mikolaj_oszczedlowski.spring_first_project.models.Book;

public interface BooksRepository extends JpaRepository<Book, Long>{
    
}
