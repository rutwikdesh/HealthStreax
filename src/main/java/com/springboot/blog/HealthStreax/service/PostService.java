package com.springboot.blog.HealthStreax.service;

import com.springboot.blog.HealthStreax.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);
}
