package de.howtohelppeople.postings;

import de.howtohelppeople.postings.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

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
        return postingRepository.saveAndFlush(posting);
    }

    public Collection<PostingEntity> getAllpostings() {
        LOGGER.debug("Getting all postings");
        return postingRepository.findAll();
    }

    public PostingSearchResponse getPostings(String zipCode, String distance, List<String> skillSets) {
        LOGGER.debug("Getting postings for areaCode: " + zipCode);
        List<PostingEntity> postingEntities = postingRepository.findByAreaCode(zipCode);
        return new PostingSearchResponse(postingEntities);
    }
}
