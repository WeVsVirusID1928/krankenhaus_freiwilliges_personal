package de.howtohelppeople.postings;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.howtohelppeople.postings.repository.HospitalEntity;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(path = "/hospital")
@ResponseBody
@Slf4j
public class HospitalPort {
    private final HospitalService hospitalService;

    @Autowired
    public HospitalPort(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> onResRequest(
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon,
            @RequestParam("distance") double distance) {

        return ResponseEntity.ok(
                new Gson().toJson(hospitalService.getAllHospitalsWithDistance(lat, lon, distance))
        );
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllPostings() {
        return new Gson().toJson(hospitalService.getAllHospitals());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createHospital(@RequestBody HospitalEntity hospital) {
        log.debug("Processing hospital create: {}", hospital.toString());

        try {
            HospitalEntity createdHospital = hospitalService.create(hospital);

            JsonObject result = new JsonObject();
            result.addProperty("id", createdHospital.getId());
            return result.toString();
        } catch (DataIntegrityViolationException e) {
            log.warn("Exception occurred when trying to save the hospital", e);
            JsonObject result = new JsonObject();
            result.addProperty("error", e.getMessage());
            return result.toString();
        }
    }
}
