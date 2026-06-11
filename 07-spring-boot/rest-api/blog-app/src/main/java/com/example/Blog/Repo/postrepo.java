package com.example.Blog.Repo;

import com.example.Blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postrepo extends JpaRepository<Post, Integer> {

}