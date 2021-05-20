package com.evolv.assignment.blog.service.impl;

import com.evolv.assignment.blog.model.Post;
import com.evolv.assignment.blog.service.PostService;
import com.evolv.assignment.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService
{
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> findForId(Integer id) {
        return postRepository.getById(id);
    }

    @Override
    public Collection<Post> findAllByDate() {
        return postRepository.findAllByOrderByCreateDateDesc();
    }

    @Override
    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }


}
