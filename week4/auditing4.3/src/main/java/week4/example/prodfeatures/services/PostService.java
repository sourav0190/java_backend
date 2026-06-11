package week4.example.prodfeatures.services;

import week4.example.prodfeatures.dto.PostDto;
import java.util.List;

public interface PostService {
    PostDto createPost(PostDto dto);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long postId);

    PostDto updatePost(Long postId, PostDto dto);
    void getPostHistory(Long postId);
}
