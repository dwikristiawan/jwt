package com.example.demo.service.implement;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Users register(UserDto userDto) {
        Users user = new Users();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return user;
    }

    @Override
    public Users findUserByUsername(String username) {
        Users user= userRepository.findByUsername(username);
        return user;
    }
}
