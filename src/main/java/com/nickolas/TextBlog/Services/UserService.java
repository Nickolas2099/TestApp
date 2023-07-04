package com.nickolas.TextBlog.Services;

import com.nickolas.TextBlog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



}
