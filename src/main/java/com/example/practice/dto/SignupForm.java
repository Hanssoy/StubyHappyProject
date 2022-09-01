package com.example.practice.dto;

import com.example.practice.entity.User;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class SignupForm {
    private Long id;
    private String username;
    private String userId;
    private String userPw;

    public User toEntity() {return new User(id, username, userId, userPw, null);}
}
