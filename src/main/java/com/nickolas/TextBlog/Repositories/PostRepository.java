package com.nickolas.TextBlog.Repositories;

import com.nickolas.TextBlog.Posting.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostById(int id);
}
