package com.evolv.assignment.blog.service.impl;

import com.evolv.assignment.blog.model.Comment;
import com.evolv.assignment.blog.repository.CommentRepository;
import com.evolv.assignment.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService
{
    CommentRepository commentRepository;

    @Autowired
    public CommentServiceImp(CommentRepository commentRepository)
    {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment comment)
    {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Collection<Comment> findCommentByPostId(Integer postId)
    {
        return commentRepository.findAllByPostId(postId);
    }

    @Override
    public Optional<Comment> findForId(Integer id)
    {
        return commentRepository.getById(id);
    }
}