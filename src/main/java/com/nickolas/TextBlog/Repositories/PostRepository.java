package com.nickolas.TextBlog.Repositories;

import com.nickolas.TextBlog.Posting.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostById(int id);
}
