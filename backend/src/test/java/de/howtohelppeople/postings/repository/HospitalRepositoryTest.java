package de.howtohelppeople.postings.repository;

import de.howtohelppeople.TestApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = {TestApp.class}
)
@Tag("integration")
class HospitalRepositoryTest  {

	@Autowired
	HospitalRepository hospitalRepository;


	@BeforeEach
	void setUp() {
		createHospital("NearPointHospital",new Point(5.00,10.0));
		createHospital("AwayPointHospital",new Point(5.00,100.0));
	}

	@Test
	void shouldGetNearestHospital() {
//		List<HospitalEntity> allWithin = hospitalRepository.findAllWithin();
//		assertThat(allWithin.get(0).getName()).isGreaterThanOrEqualTo("AwayPointHospital");
	}


	private void createHospital(String name, Point point){
		HospitalEntity hospitalEntity = HospitalSpec.valid().name(name).location(point).build();
		hospitalRepository.saveAndFlush(hospitalEntity);
	}
}