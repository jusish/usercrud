package com.spring.usercrud.services;

import com.spring.usercrud.dtos.CreateBookDto;
import com.spring.usercrud.models.Book;

public interface BookService {
    Book createBook(CreateBookDto dto) throws Exception;
}
