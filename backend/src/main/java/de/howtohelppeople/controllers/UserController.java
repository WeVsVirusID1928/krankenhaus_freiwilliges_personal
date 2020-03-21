package de.howtohelppeople.controllers;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.howtohelppeople.entities.UserEntity;
import de.howtohelppeople.model.User;
import de.howtohelppeople.services.UserService;

@Controller
@RequestMapping(path = "/user")
@ResponseBody
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> onResRequest(@RequestParam(value = "id") String id) {
        Long Id = Long.parseLong(id);
        return ResponseEntity.ok(userService.getUserStats(Id));
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllUsers() {
        return new Gson().toJson(userService.getAllUsers());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody User user) {
        LOGGER.debug("Processing user create:" + user.toString());

        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(user.getEmail());
            userEntity.setPasswordHash(new BCryptPasswordEncoder().encode(user.getPasswordPlain()));
            userEntity.setUserName(user.getUserName());

            UserEntity createdUser = userService.create(userEntity);

            return "{\"id\": \"" + createdUser.getId() + "\"}";

        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the user", e);
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }
    }
}