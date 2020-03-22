package de.howtohelppeople.postings;

import com.google.gson.Gson;
import de.howtohelppeople.postings.repository.PostingEntity;
import de.howtohelppeople.postings.repository.PostingSearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/search")
@ResponseBody
public class PostingPort {
	private static final Logger LOGGER = LoggerFactory.getLogger(PostingPort.class);

	private final PostingService postingService;

	@Autowired
	public PostingPort(PostingService postingService) {
		this.postingService = postingService;
	}

	@RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> onResRequest(
			@RequestParam("zipCode") String zipCode,
			@RequestParam("distance") String distance,
			@RequestParam("skillSet") List<String> skillSet) {

		return ResponseEntity.ok(
				new Gson().toJson(
						postingService.getPostings(zipCode, distance, skillSet))
		);
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