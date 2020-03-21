package de.howtohelppeople.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import de.howtohelppeople.entities.UserEntity;
import de.howtohelppeople.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }

    public Collection<UserEntity> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll();
    }

    public String getUserStats(Long id) {
        UserEntity user = userRepository.findById(id);
        String result = "{ID : " + user.getId().toString() + ", Name: " + user.getUserName() + ", email:" + user.getEmail() + " }";

        return result;
    }
}