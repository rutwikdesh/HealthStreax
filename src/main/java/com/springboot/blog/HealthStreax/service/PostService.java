package com.springboot.blog.HealthStreax.service;

import com.springboot.blog.HealthStreax.dto.PostDto;
import com.springboot.blog.HealthStreax.dto.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePostById(PostDto postDto, long id);
    void deletePostById(long id);
}
