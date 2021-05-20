package com.evolv.assignment.blog.controller;

import com.evolv.assignment.blog.model.Post;
import com.evolv.assignment.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PostController
{
    private PostService postService;

    @Autowired
    public PostController(PostService postService)
    {
        this.postService = postService;
    }

    @PostMapping("/addPost")
    public String addPost(@RequestBody @Valid Post post) {
        postService.save(post);
        return "Added new post to the blog!";
    }

    @GetMapping("/listPosts")
    public Iterable<Post> getPosts() {
        return postService.findAllByDate();
    }

    @GetMapping("/findPost/{id}")
    public Post findPostById(@PathVariable Integer id) {
        Optional<Post> optionalPost  = postService.findForId(id);
        if(optionalPost.isPresent())
            return optionalPost.get();
        return null;
    }

    @PutMapping("/updatePost/{id}")
    public String updatePostById(@RequestBody @Valid Post post, @PathVariable Integer id)
    {
        Optional<Post> optionalPost = postService.findForId(id);
        if(optionalPost.isPresent())
        {
            post.setId(id);
            postService.save(post);
            return "Post updated successfully";
        }
        return "Post does not exist";
    }

    @DeleteMapping("/deletePost/{id}")
    public String deletePostById(@PathVariable Integer id)
    {
        Post post = findPostById(id);
        if(post == null)
            return "Post does not exist";
        else
        {
            postService.delete(post);
            return "Post successfully deleted";
        }
    }

}