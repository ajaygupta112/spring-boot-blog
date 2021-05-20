package com.evolv.assignment.blog.service;

import com.evolv.assignment.blog.model.Post;

import java.util.Collection;
import java.util.Optional;

public interface PostService
{
    Optional<Post> findForId(Integer id);

    Post save(Post post);

    //Post update(Integer id)

    Collection<Post> findAllByDate();

    void delete(Post post);
}
