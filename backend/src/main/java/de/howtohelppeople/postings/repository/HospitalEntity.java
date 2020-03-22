package de.howtohelppeople.postings.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    public static final String TABLE_NAME = "hospitals";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    Long id;

    private String name;
    private String street;
    private String zipCode;
    private String country;
    private String city;
    private double latitude;
    private double longitude;
    private String phoneNumber;
    private String faxNumber;
    private String email;


    @Builder
    public HospitalEntity(String name, String street, String zipCode, String country, String city, double latitude, double longitude, String phoneNumber, String faxNumber, String email) {
        this.name = name;
        this.street = street;
        this.zipCode = zipCode;
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.email = email;
    }
}