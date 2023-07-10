package com.nickolas.TextBlog.Services;

import com.nickolas.TextBlog.Posting.User;
import com.nickolas.TextBlog.Repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService implements ParentService<User> {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


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
        User user = userRepository.findById(id).orElse(new User());
        log.debug("get User by id: {}", user);
        return user;
    }
}
