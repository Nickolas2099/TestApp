package com.nickolas.TextBlog.Repositories;

import com.nickolas.TextBlog.Posting.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    
    @Query(value = "SELECT * FROM post ORDER BY post_time DESC", nativeQuery = true)
    List<Post> getAll();
}
