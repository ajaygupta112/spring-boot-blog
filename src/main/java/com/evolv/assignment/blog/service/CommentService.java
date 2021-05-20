package com.evolv.assignment.blog.service;

import com.evolv.assignment.blog.model.Comment;

import java.util.Collection;
import java.util.Optional;

public interface CommentService
{
    Comment save(Comment comment);

    Collection<Comment> findCommentByPostId(Integer postId);

    Optional<Comment> findForId(Integer id);
}
