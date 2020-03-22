package de.howtohelppeople.postings.repository;

import org.springframework.data.geo.Point;

public class HospitalSpec {

	public HospitalEntity VALID = valid().build();

	public static HospitalEntity.HospitalEntityBuilder valid(){
		return HospitalEntity.builder()
				.city("someCity")
				.country("someCountry")
				.email("someEmail@Somthing.de")
				.faxNumber("someFaxNumber")
				.latitude("10")
				.longitude("20")
				.location(new Point(10.0,20.0))
				.name("someHospital")
				.phoneNumber("somePhoneNumber")
				.street("someStreet")
				.zipCode("someZipCode");
	}
}
