package com.example.practice.controller;

import com.example.practice.dto.SignupForm;
import com.example.practice.entity.User;
import com.example.practice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
// 사용자 계정 controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/login")
    public String userLogin(){
        return "/userAccounts/login";
    }

    @GetMapping("/user/signup")
    public String userSignup(){ return "/userAccounts/signup"; }


    @PostMapping("/user/signup/create")
    public String userSignupCreate(SignupForm form){
        log.info(form.toString());

        // dto를 entity로 변환
        User user = form.toEntity();

        // repository를 통해 entity를 db에 저장
        User saved = userRepository.save(user);

        return "redirect:/user/login";
    }
}
