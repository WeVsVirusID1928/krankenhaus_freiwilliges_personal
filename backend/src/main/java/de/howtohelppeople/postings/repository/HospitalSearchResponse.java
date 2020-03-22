package de.howtohelppeople.postings.repository;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HospitalSearchResponse {

    @JsonAlias("hospitals")
    List<HospitalEntity> hospitalEntities;
}
