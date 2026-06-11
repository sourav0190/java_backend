package week4.example.prodfeatures.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import week4.example.prodfeatures.dto.PostDto;
import week4.example.prodfeatures.services.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor

public class PostController {
    private final PostService postService;

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @GetMapping
    public List<PostDto> getAllPost() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }
    @PutMapping("/{postId}")
    public PostDto updatePost(@PathVariable Long postId,@RequestBody PostDto postDto) {
        return postService.updatePost(postId,postDto);
    }
    @GetMapping("/{postId}/history")
    public void getPostHistory(@PathVariable Long postId) {
        postService.getPostHistory(postId);
    }




}
