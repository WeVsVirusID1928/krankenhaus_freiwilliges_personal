package de.howtohelppeople.postings.repository;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hospitals")
public class HospitalEntity {

	@Id
	@GeneratedValue
	Long id;

	private String name;
	private String street;
	private String zipCode;
	private String country;
	private String city;
	private String latitude;
	private String longitude;
	private String phoneNumber;
	private String faxNumber;
	private String email;

}