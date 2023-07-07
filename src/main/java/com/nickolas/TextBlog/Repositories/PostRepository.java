package com.nickolas.TextBlog.Repositories;

import com.nickolas.TextBlog.Posting.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Modifying
    @Query(value = "UPDATE Post SET content=?1 WHERE ID = ?2")
    void updatePost(String text, int id);
}
