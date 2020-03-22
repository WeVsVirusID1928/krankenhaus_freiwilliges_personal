package de.howtohelppeople.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import de.howtohelppeople.postings.repository.PostingSearchResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperFactory {

	@Bean
	public ObjectMapper getJsonMapper() {
		var mapper = new ObjectMapper();
		configureMapper(mapper);
		return mapper;
	}

	private void configureMapper(ObjectMapper mapper) {

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true);
		mapper.registerSubtypes(new NamedType(PostingSearchResponse.class));
		mapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
	}
}
