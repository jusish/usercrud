package com.spring.usercrud.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.spring.usercrud.dtos.CreateBookDto;
import com.spring.usercrud.servicesImpl.BookServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookServiceImpl bookServiceImpl;

    BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }
    @PostMapping("/create")
    public ResponseEntity createBook(@RequestBody CreateBookDto dto) throws Exception {
        return ResponseEntity.ok(bookServiceImpl.createBook(dto));
    }
    
}
