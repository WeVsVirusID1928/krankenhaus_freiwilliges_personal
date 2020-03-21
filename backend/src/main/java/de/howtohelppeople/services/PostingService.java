package de.howtohelppeople.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import javax.transaction.Transactional;

import de.howtohelppeople.entities.PostingEntity;
import de.howtohelppeople.repositories.PostingRepository;

@Service
@Transactional
public class PostingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostingService.class);

    private PostingRepository postingRepository;

    @Autowired
    public PostingService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    public PostingEntity create(PostingEntity posting) {
        return postingRepository.save(posting);
    }

    public Collection<PostingEntity> getAllpostings() {
        LOGGER.debug("Getting all postings");
        return postingRepository.findAll();
    }

    public Collection<PostingEntity> getPostings(String areaCode) {
        LOGGER.debug("Getting postings for areaCode: " + areaCode);
        return postingRepository.findByAreaCode(areaCode);
    }
}
