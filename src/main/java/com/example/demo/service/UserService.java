package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
 //   public String register(RegisterRequest registerData);
    public Users register(UserDto userDto);
    public Users findUserByUsername(String Username);
}
