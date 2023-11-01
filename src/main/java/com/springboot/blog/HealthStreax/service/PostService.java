package com.springboot.blog.HealthStreax.service;

import com.springboot.blog.HealthStreax.dto.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
