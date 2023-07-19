package com.nickolas.TextBlog.Services;

import com.nickolas.TextBlog.Posting.Post;
import com.nickolas.TextBlog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements ParentService<Post> {

    @Autowired
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public void create(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.getAll();
    }

    public Post getById(int id) {
        return postRepository.findById(id).orElse(new Post());
    }

    public void update(int id, Post post) {
        postRepository.save(post);
    }

    public void delete(int id) {
        postRepository.deleteById(id);
    }
}
