package com.spring.usercrud.dtos;

import com.spring.usercrud.classes.Address;
import com.spring.usercrud.enums.UserRole;

public class UpdateUserDto {
    private String name;
    private String email;
    private String password;
    private UserRole role;
    private Address address;
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
}
