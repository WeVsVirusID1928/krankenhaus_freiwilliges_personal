package de.howtohelppeople.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.howtohelppeople.entities.UserEntity;
import de.howtohelppeople.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserStats(Long id) {
        UserEntity user = userRepository.findById(id);
        String result = "{ID : " + user.getId().toString() + ", Name: " + user.getUserName() + ", email:" + user.getEmail() + " }";

        return result;
    }
}