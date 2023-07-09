package com.nickolas.TextBlog.Services;

import com.nickolas.TextBlog.Posting.User;
import com.nickolas.TextBlog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ParentService<User> {

    @Autowired
    UserRepository userRepository;


    @Override
    public void create(User user) {
        userRepository.save(user);
    }
    //ПОЧИТАТЬ ПРО СЕССИИ, ДЛЯ ДОБАВЛЕНИЯ ИМЕНИ ПОЛЬЗОВАТЕЛЯ В ПОСТ
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(int id, User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElse(new User());
    }
}
