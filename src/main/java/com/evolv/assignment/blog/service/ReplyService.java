package com.evolv.assignment.blog.service;

import com.evolv.assignment.blog.model.Reply;

import java.util.Collection;

public interface ReplyService
{
    Reply saveReply(Reply reply);
    Collection<Reply> findReplyByCommentId(Integer commentId);
}
