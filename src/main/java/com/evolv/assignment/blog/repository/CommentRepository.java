package com.evolv.assignment.blog.repository;

import com.evolv.assignment.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer>
{
    /*
    Optional<Comment> findCommentById(Integer id);

    Collection<Comment> findAllByOrderByCreateDateDesc();
     */

    Collection<Comment> findAllByPostId(Integer id);

    Optional<Comment> getById(Integer id);
}
