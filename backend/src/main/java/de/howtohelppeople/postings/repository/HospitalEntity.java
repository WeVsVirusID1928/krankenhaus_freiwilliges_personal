package de.howtohelppeople.postings.repository;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;
import org.springframework.data.geo.Point;

import javax.persistence.*;

import static de.howtohelppeople.postings.repository.HospitalEntity.TABLE_NAME;

@Data
@NoArgsConstructor(
		access = AccessLevel.PROTECTED
)
@Entity
@Table(name = TABLE_NAME)
@SequenceGenerator(
		name = "default_generator",
		sequenceName = "seq_" + TABLE_NAME,
		allocationSize = 1)
@ToString(exclude = {"id"})
public class HospitalEntity {
	public static final String TABLE_NAME = "Hospitals";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
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

	@Column(columnDefinition = "geometry")
	private Point location;


}