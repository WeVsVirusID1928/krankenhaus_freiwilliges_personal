package de.howtohelppeople.postings;

import de.howtohelppeople.postings.repository.PostingSearchResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class PostingPortTest {

	PostingPort postingPort;
	private PostingService postingService;

	@BeforeEach
	void setUp() {

		postingService = mock(PostingService.class);
		postingPort = new PostingPort(postingService);
	}

	@Test
	void shouldRequestPostingForCertainZipCodeDistanceAndSkillSet() {
		//Given
		String zipCode = "someZipCode";
		String distance = "someDistance";
		List<String> skillSet= List.of("someSkill1", "someSkill2");
		//When
		postingPort.onResRequest(zipCode,distance,skillSet);
		//Then
		ArgumentCaptor<PostingSearchResponse> captor = ArgumentCaptor.forClass(PostingSearchResponse.class);
		verify(postingService, times(1)).getPostings(eq(zipCode),eq(distance),eq(skillSet));

	}
}