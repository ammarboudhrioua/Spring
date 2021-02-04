package com.FivePoints.Spring.services;

import com.FivePoints.Spring.models.Post;
import com.FivePoints.Spring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> allPosts() {
        return this.postRepository.findAll();
    }

        public String addPost(Post newPost) {
            this.postRepository.save(newPost);
            return "User added successfully" ;

        }

    public Optional<Post> findPost(Integer id) {
        return postRepository.findById(id);

    }
    public String deletePost(Integer id){
        postRepository.deleteById(id);
        return "deleted";

    }
    public Optional<Post> updatePost(Integer id, Post newPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(newPost.getTitle());
                    post.setDescription(newPost.getDescription());
                    return postRepository.save(post);
                });

    }
    public Post findPostByTitle(String title){
     return postRepository.findByTitle(title);
    }
}
