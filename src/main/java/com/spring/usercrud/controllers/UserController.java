package com.spring.usercrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.usercrud.dtos.CreateUserDto;
import com.spring.usercrud.dtos.UpdateUserDto;
import com.spring.usercrud.servicesImpl.UserServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserServiceImp userService;
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody CreateUserDto dto) throws Exception {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(userService.getUser(id));
    }

@PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody UpdateUserDto dto, @PathVariable("id") Long id)throws Exception{
        return ResponseEntity.ok(userService.updateUser(dto, id));
    }
}
