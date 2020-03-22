package de.howtohelppeople.postings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingRepository extends JpaRepository<PostingEntity, String> {

    PostingEntity findById(Long id);

    List<PostingEntity> findByAreaCode(String areaCode);

}