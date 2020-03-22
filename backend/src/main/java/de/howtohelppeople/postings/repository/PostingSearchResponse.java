package de.howtohelppeople.postings.repository;

import com.fasterxml.jackson.annotation.JsonAlias;
import de.howtohelppeople.config.events.Payload;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
public class PostingSearchResponse {

	@JsonAlias("postings")
	List<PostingEntity> postingEntities;
}
