package com.nickolas.TextBlog.Services;

import com.nickolas.TextBlog.Posting.Post;
import com.nickolas.TextBlog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements ParentService<Post> {

    @Autowired
    PostRepository postRepository;

    public void create(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post getById(int id) {
        return null;
    }

    public void update(int id, Post post) {

    }

    public void delete(int id) {

    }
}
