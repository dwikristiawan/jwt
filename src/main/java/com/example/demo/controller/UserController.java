package com.example.demo.controller;

import com.example.demo.dto.AuthenticationDto;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.NetworkResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {
//    @Autowired
 //   RegisterResponse response;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsServiceImplement;
    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/register")
    NetworkResult<Object> Register(@RequestBody UserDto userDto){
        NetworkResult<Object> response = new NetworkResult<>();
        Users users=userService.findUserByUsername(userDto.getUsername());
        if(users!=null){
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setResponseMessage("Username sudah terdaftar");
            return response;
        }
        users=userService.register(userDto);
        response.setResponseCode(HttpStatus.OK.value());
        response.setResponseMessage("Berhasil mendaftarkan akun");
        return response;
    }
    @PostMapping("/login")
    public ResponseEntity <?> login(@RequestBody AuthenticationDto authenticationDto, HttpServletResponse response) throws Exception {
        try {
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authenticationDto.getUsername(), authenticationDto.getPassword())
           );
       }catch (BadCredentialsException e){ throw new Exception("Incorect username or password",e);
       }
       final UserDetails userDetails= userDetailsServiceImplement
               .loadUserByUsername(authenticationDto.getUsername());
       final String jwt= jwtUtils.generateToken(userDetails);
       return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
