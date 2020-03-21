package de.howtohelppeople.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.howtohelppeople.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findById(Long id);

}