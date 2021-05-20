package com.evolv.assignment.blog.service.impl;

import com.evolv.assignment.blog.model.Reply;
import com.evolv.assignment.blog.repository.ReplyRepository;
import com.evolv.assignment.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReplyServiceImp implements ReplyService
{
    ReplyRepository replyRepository;

    @Autowired
    public ReplyServiceImp(ReplyRepository replyRepository)
    {
        this.replyRepository = replyRepository;
    }

    @Override
    public Reply saveReply(Reply reply)
    {
        return replyRepository.saveAndFlush(reply);
    }

    @Override
    public Collection<Reply> findReplyByCommentId(Integer commentId)
    {
        return replyRepository.findAllByCommentId(commentId);
    }
}
