package com.evolv.assignment.blog.repository;

import com.evolv.assignment.blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReplyRepository extends JpaRepository<Reply, Integer>
{
    Collection<Reply> findAllByCommentId(Integer id);
}
