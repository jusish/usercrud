package com.spring.usercrud.dtos;

import com.spring.usercrud.models.User;

public class CreateBookDto {
    private String name;
    private long user_id;
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
