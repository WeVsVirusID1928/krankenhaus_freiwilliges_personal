package de.howtohelppeople.postings.repository;

import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalRepository extends JpaRepository<HospitalEntity, String> {

    /**
     * Example method of a GIS query. This uses Hibernate spatial extensions, so
     * it does not work with other JPA implementations.
     *
     * @param bounds the geometry
     * @return SpatialEvents inside given geometry and with given filter for the title
     */

	@Query(value = "SELECT se FROM HospitalEntity se WHERE within (se.location, :bounds) = true")
	public List<HospitalEntity> findAllWithin(@Param("bounds") Geometry bounds);
}
