package de.howtohelppeople.controllers;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.howtohelppeople.entities.PostingEntity;
import de.howtohelppeople.services.PostingService;

@Controller
@RequestMapping(path = "/posting")
@ResponseBody
public class PostingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostingController.class);

    private final PostingService postingService;

    @Autowired
    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @RequestMapping(path = "/at/{areaCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> onResRequest(@PathVariable("areaCode") String areaCode) {
        return ResponseEntity.ok(new Gson().toJson(postingService.getPostings(areaCode)));
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllPostings() {
        return new Gson().toJson(postingService.getAllpostings());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createPosting(@RequestBody PostingEntity posting) {
        LOGGER.debug("Processing posting create:" + posting.toString());

        try {
            PostingEntity createdPosting = postingService.create(posting);

            return "{\"id\": \"" + createdPosting.getId() + "\"}";
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the posting", e);
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }
    }
}