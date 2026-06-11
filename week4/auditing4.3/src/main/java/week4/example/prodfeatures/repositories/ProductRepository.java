package week4.example.prodfeatures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import week4.example.prodfeatures.entities.PostEntity;

public interface ProductRepository
        extends JpaRepository<PostEntity, Long> , RevisionRepository<PostEntity, Long, Integer> {
}