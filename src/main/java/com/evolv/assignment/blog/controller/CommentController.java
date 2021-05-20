package com.evolv.assignment.blog.controller;

import com.evolv.assignment.blog.model.Comment;
import com.evolv.assignment.blog.model.Post;
import com.evolv.assignment.blog.service.CommentService;
import com.evolv.assignment.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CommentController
{
    CommentService commentService;
    PostService postService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService)
    {
        this.commentService = commentService;
        this.postService = postService;
    }

    /*
    @PostMapping("/addComment")
    public String addComment(@RequestBody @Valid Comment comment)
    {
        Optional<Post> optionalPost = postService.findForId(comment.getPost().getId());
        if(optionalPost.isPresent())
        {
            commentService.save(comment);
            return "New comment added to the post";
        }
        return "Post does not exist";
    }
     */


    @PostMapping("/addComment/{id}/comment")
    public String addComment(@PathVariable Integer id, @RequestParam String body)
    {
        Optional<Post> optionalPost = postService.findForId(id);
        if(optionalPost.isPresent())
        {
            Comment comment = new Comment();
            comment.setPost(optionalPost.get());
            comment.setBody(body);
            commentService.save(comment);
            return "New comment added to the post";
        }
        return "Post does not exist";
    }


    @GetMapping("listComments/{id}")
    public Iterable<Comment> getComments(@PathVariable Integer id)
    {
        Optional<Post> optionalPost = postService.findForId(id);
        if(optionalPost.isPresent())
        {
            return commentService.findCommentByPostId(id);
        }
        return null;
    }

}
