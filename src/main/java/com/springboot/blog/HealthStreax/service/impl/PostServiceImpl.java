package com.springboot.blog.HealthStreax.service.impl;

import com.springboot.blog.HealthStreax.dto.PostDto;
import com.springboot.blog.HealthStreax.entity.Post;
import com.springboot.blog.HealthStreax.repository.PostRepository;
import com.springboot.blog.HealthStreax.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {


        // Converting Dto to Entity & saving to DB
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepository.save(post);

        // Converting Entity to Dto
        PostDto postResponse = new PostDto();
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setContent(savedPost.getContent());
        postResponse.setDescription(savedPost.getDescription());

        return postResponse;
    }
}
