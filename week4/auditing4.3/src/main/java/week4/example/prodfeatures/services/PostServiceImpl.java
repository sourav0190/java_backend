package week4.example.prodfeatures.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;
import week4.example.prodfeatures.dto.PostDto;
import week4.example.prodfeatures.entities.PostEntity;
import week4.example.prodfeatures.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto dto) {
        PostEntity post = modelMapper.map(dto, PostEntity.class);
        PostEntity savedPost = productRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostEntity> posts = productRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public PostDto getPostById(Long postId){
        PostEntity post = productRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("post not found" +  postId));
        return modelMapper.map(post, PostDto.class);
    }
  
@Override
public PostDto updatePost(Long postId, PostDto postDto) {
    // 1. Purana Post database se nikalein
    PostEntity existingPost = productRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("post not found with id: " + postId));

    // 2. ModelMapper se existingPost ki fields update karein
    modelMapper.map(postDto, existingPost);
    
    // ⚠️ ID ko safe rakhne ke liye: ModelMapper DTO ki null ID copy kar ke existing ID ko overwrite na kare
    existingPost.setId(postId); 

    // 3. Database me update/save karein
    PostEntity savedPost = productRepository.save(existingPost);

    // 4. DTO map karke return karein
    return modelMapper.map(savedPost, PostDto.class);
}
    public void getPostHistory(Long postId) {
    // Post ke saare purane versions check karein
    Revisions<Integer, PostEntity> revisions = productRepository.findRevisions(postId);
    
    for (Revision<Integer, PostEntity> revision : revisions) {
        System.out.println("Revision Number: " + revision.getRequiredRevisionNumber());
        System.out.println("Revision Date: " + revision.getRequiredRevisionInstant());
        System.out.println("Post Data in this revision: " + revision.getEntity());
    }
}

}




