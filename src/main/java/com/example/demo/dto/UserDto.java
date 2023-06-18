package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserDto {
    private Long Id;
    private String username;
    private String email;
    private String password;
}
