package com.spring.usercrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.usercrud.models.Book;

public interface BookRepository  extends JpaRepository<Book, Long>{
    
}
