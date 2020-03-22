package de.howtohelppeople.postings.repository;

public class HospitalSpec {

    public HospitalEntity VALID = valid().build();

    public static HospitalEntity.HospitalEntityBuilder valid() {
        return HospitalEntity.builder()
                .city("someCity")
                .country("someCountry")
                .email("someEmail@Somthing.de")
                .faxNumber("someFaxNumber")
                .latitude(10.0)
                .longitude(20.0)
                .name("someHospital")
                .phoneNumber("somePhoneNumber")
                .street("someStreet")
                .zipCode("someZipCode");
    }
}
