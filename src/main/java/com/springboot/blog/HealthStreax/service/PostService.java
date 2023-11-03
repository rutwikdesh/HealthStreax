package com.springboot.blog.HealthStreax.service;

import com.springboot.blog.HealthStreax.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts(int pageNo, int pageSize);
    PostDto getPostById(long id);
    PostDto updatePostById(PostDto postDto, long id);
    void deletePostById(long id);
}
