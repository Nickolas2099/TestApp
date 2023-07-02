package com.nickolas.TextBlog.Repositories;

import com.nickolas.TextBlog.Posting.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
