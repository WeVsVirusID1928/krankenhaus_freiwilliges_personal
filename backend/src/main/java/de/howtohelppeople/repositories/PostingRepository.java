package de.howtohelppeople.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import de.howtohelppeople.entities.PostingEntity;

@Repository
public interface PostingRepository extends JpaRepository<PostingEntity, String> {

    PostingEntity findById(Long id);

    List<PostingEntity> findByAreaCode(String areaCode);

}