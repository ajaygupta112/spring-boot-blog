package com.evolv.assignment.blog.repository;

import com.evolv.assignment.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer>
{
    Optional<Post> getById(Integer id);

    Collection<Post> findAllByOrderByCreateDateDesc();
}