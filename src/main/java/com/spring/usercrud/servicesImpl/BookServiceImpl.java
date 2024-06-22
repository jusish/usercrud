package com.spring.usercrud.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.usercrud.dtos.CreateBookDto;
import com.spring.usercrud.models.Book;
import com.spring.usercrud.models.User;
import com.spring.usercrud.repositories.BookRepository;
import com.spring.usercrud.repositories.UserRepository;
import com.spring.usercrud.services.BookService;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    BookServiceImpl(BookRepository bookRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userRepository  = userRepository;
    }

    @Override
    public Book createBook(CreateBookDto dto) throws Exception {
        try {
            if (dto.getName() == null || dto.getUser_id() == 0 ){
                throw new Exception("Book name cannot be null");
            } else {
                User user = userRepository.findById(dto.getUser_id()).orElseThrow(()-> new Exception("User not found"));
                Book book = new Book();
                book.setName(dto.getName());
                book.setUser(user);
                user.getBooks().add(book);
                bookRepository.save(book);
                userRepository.save(user);

                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
       
    }
}
