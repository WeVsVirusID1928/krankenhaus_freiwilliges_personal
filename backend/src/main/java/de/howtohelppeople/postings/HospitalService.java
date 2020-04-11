package de.howtohelppeople.postings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import de.howtohelppeople.postings.repository.HospitalEntity;
import de.howtohelppeople.postings.repository.HospitalRepository;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class HospitalService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HospitalService.class);

    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalEntity create(HospitalEntity hospital) {
        return hospitalRepository.saveAndFlush(hospital);
    }

    public Collection<HospitalEntity> getAllHospitals() {
        LOGGER.debug("Getting all hospitals");
        return hospitalRepository.findAll();
    }

    public HospitalEntity getHospitalById(Long id) {
        LOGGER.debug("Get hospital for Id" + id);
        return hospitalRepository.findById(id);
    }

    public List<HospitalEntity> getAllHospitalsWithDistance(double lat, double lon, double distanceInMeters) {
        LOGGER.debug("Getting all hospitals");
        Collection<HospitalEntity> hospitals = hospitalRepository.findAll();

        return hospitals.stream().filter((hospital) -> {
            return false;
            // return getDistanceMeters(lat, lon, hospital.getLatitude(), hospital.getLongitude()) <= distanceInMeters;
        }).collect(toList());
    }

//    public double getDistanceMeters(double lat1, double lon1, double lat2, double lon2) {
//        GeodeticCalculator calc = new GeodeticCalculator();
//        calc.setStartingGeographicPoint(lon1, lat1);
//        calc.setDestinationGeographicPoint(lon2, lat2);
//        double distance = calc.getOrthodromicDistance();

//        return new Measure(distance, SI.METRE).doubleValue();
//        return lat
//    }
}
