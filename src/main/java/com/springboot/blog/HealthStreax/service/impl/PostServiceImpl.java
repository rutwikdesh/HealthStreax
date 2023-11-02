package com.springboot.blog.HealthStreax.service.impl;

import com.springboot.blog.HealthStreax.dto.PostDto;
import com.springboot.blog.HealthStreax.entity.Post;
import com.springboot.blog.HealthStreax.exception.ResourceNotFoundException;
import com.springboot.blog.HealthStreax.repository.PostRepository;
import com.springboot.blog.HealthStreax.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Post post = dtoToEntity(postDto);

        Post savedPost = postRepository.save(post);

        // Converting Entity to Dto
        PostDto postResponse = entityToDto(post);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> entityToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        PostDto postDto = entityToDto(post);
        return postDto;
    }


    public PostDto entityToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        return postDto;
    }

    public Post dtoToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return post;
    }
}
