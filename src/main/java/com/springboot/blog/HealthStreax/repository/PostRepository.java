package com.springboot.blog.HealthStreax.repository;

import com.springboot.blog.HealthStreax.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
