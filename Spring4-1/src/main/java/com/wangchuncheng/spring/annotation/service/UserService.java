package com.wangchuncheng.spring.annotation.service;

import com.wangchuncheng.spring.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    @Qualifier("userJdbcRepository")
    private UserRepository userRepository;
    public void add(){
        System.out.println("UserService add...");
        userRepository.save();
    }
}
