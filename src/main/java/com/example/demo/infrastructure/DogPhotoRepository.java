package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository 
public interface DogPhotoRepository extends JpaRepository<DogPhotoEntity, Long>{
    List<DogPhotoEntity> findByDogId(Long dogId);
}
