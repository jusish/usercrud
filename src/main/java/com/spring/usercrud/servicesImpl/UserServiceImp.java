package com.spring.usercrud.servicesImpl;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.usercrud.classes.Address;
import com.spring.usercrud.dtos.CreateUserDto;
import com.spring.usercrud.dtos.UpdateUserDto;
import com.spring.usercrud.enums.UserRole;
import com.spring.usercrud.models.User;
import com.spring.usercrud.repositories.UserRepository;
import com.spring.usercrud.services.UserService;


@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public String createUser(CreateUserDto dto) throws Exception {
        try {
            if (dto.getName() == null || dto.getEmail() == null || dto.getPassword() == null || dto.getAddress().getDistrict() == null || dto.getAddress().getSector() == null) {
                throw new BadRequestException("All user credentials are required");
                
            } else {
                User user = new User();
                user.setName(dto.getName());
                user.setEmail(dto.getEmail());
                user.setPassword(dto.getPassword());
                user.setRole(dto.getRole());
                user.setAddress(dto.getAddress());
                userRepository.save(user);
                return "User created successfully";
            }
        } catch (Exception e) {
           e.printStackTrace();
           throw new Exception(e.getMessage());
        }
    }

    @Override
    public String deleteUser(long id) throws Exception {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new Exception(String.format("User %id not found", id)));
            userRepository.delete(user);
            return "User deleted successfully";

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User updateUser(UpdateUserDto dto, Long id) throws Exception {
        try{
            User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found!"));
            String name = dto.getName() == null ? user.getName() : dto.getName();
            String email = dto.getEmail() == null ? user.getEmail() : dto.getEmail();
            String password = dto.getPassword() == null ? user.getPassword() : dto.getPassword();
            UserRole role = dto.getRole() == null ? user.getRole() : dto.getRole();
            Address address = dto.getAddress() == null ? user.getAddress() : dto.getAddress();

            user.setAddress(address);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role);
            userRepository.save(user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User getUser(long id) throws Exception {
        try {
            return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));           
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<User> getAllusers() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllusers'");
    }
    
}
