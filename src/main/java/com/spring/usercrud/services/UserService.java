package com.spring.usercrud.services;

import com.spring.usercrud.dtos.CreateUserDto;
import com.spring.usercrud.dtos.UpdateUserDto;
import com.spring.usercrud.models.User;

import java.util.*;

public interface UserService {
    String createUser(CreateUserDto dto)throws Exception;


    String deleteUser(long id) throws Exception;

    User updateUser(UpdateUserDto dto, Long id) throws Exception;

    User getUser(long id)throws Exception;

    List<User> getAllusers() throws Exception;
}
