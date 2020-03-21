package de.howtohelppeople.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.howtohelppeople.services.UserService;

@Controller
@RequestMapping(path = "/user")
@ResponseBody
public class UserController {
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
}