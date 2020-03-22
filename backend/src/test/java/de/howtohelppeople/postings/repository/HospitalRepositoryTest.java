package de.howtohelppeople.postings.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.howtohelppeople.TestApp;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {TestApp.class}
)
@Tag("integration")
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;


    @BeforeEach
    void setUp() {
        createHospital("NearPointHospital", new GeometryFactory().createPoint(new Coordinate(1, 5)));
        createHospital("AwayPointHospital", new GeometryFactory().createPoint(new Coordinate(1, 10)));
    }



    @Test
    void shouldGetNearestHospital() {
        Geometry distanceFromPoint = new GeometryFactory().createPoint(new Coordinate(1, 1)); //.buffer()


//		List<HospitalEntity> allWithin = hospitalRepository.findAllWithin();
//		assertThat(allWithin.get(0).getName()).isGreaterThanOrEqualTo("AwayPointHospital");
    }


    private void createHospital(String name, Point point) {
        HospitalEntity hospitalEntity = HospitalSpec.valid().name(name).latitude(48.10).longitude(11.5).build();
        hospitalRepository.saveAndFlush(hospitalEntity);
    }
}