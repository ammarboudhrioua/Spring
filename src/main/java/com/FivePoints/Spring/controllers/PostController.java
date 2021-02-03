package com.FivePoints.Spring.controllers;

import com.FivePoints.Spring.models.Post;
import com.FivePoints.Spring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/allPosts")
    public List<Post> all() {
        return postService.allPosts();
    }

    @PostMapping("/addPost")
    Post newPost(@RequestBody Post newPost) {
        return postService.addPost(newPost);
    }

    @GetMapping("/findPost/{id}")
    Optional<Post> findPost (@PathVariable("id") Integer id) {
        return postService.findPost(id);
    }
    @DeleteMapping("/deletePost/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        return postService.deletePost(id);
    }
    @PutMapping("/UpdatePost/{id}")
    Optional<Post> updatePost (@PathVariable("id") Integer id, @RequestBody Post newPost) {
        return postService.updatePost(id,newPost);
    }
}
