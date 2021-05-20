package com.evolv.assignment.blog.controller;

import com.evolv.assignment.blog.model.Comment;
import com.evolv.assignment.blog.model.Post;
import com.evolv.assignment.blog.model.Reply;
import com.evolv.assignment.blog.service.CommentService;
import com.evolv.assignment.blog.service.PostService;
import com.evolv.assignment.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ReplyController
{
    ReplyService replyService;
    CommentService commentService;
    PostService postService;

    @Autowired
    public ReplyController(ReplyService replyService, CommentService commentService, PostService postService)
    {
        this.replyService = replyService;
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/addReply/{id}/reply")
    public String addReplyToComment(@PathVariable Integer id, @RequestParam(value = "comment_id") Integer comment_id, @RequestParam(value = "body") String body)
    {
        Optional<Post> optionalPost = postService.findForId(id);
        if(optionalPost.isPresent())
        {
            Optional<Comment> optionalComment = commentService.findForId(comment_id);
            if(optionalComment.isPresent())
            {
                Reply reply = new Reply();
                reply.setComment(optionalComment.get());
                reply.setBody(body);
                replyService.saveReply(reply);
                return "New Reply is posted";
            }
            return "Comment does not exist";
        }
        return "Post does not exist";
    }

    @GetMapping("/listReplies/{post_id}")
    public Iterable<Reply> getReplies(@PathVariable Integer post_id, @RequestParam(value = "comment_id") Integer comment_id)
    {
        Optional<Post> optionalPost = postService.findForId(post_id);
        if(optionalPost.isPresent())
        {
            Optional<Comment> optionalComment = commentService.findForId(comment_id);
            if(optionalComment.isPresent())
            {
                return replyService.findReplyByCommentId(comment_id);
            }
        }
        return null;
    }
}
