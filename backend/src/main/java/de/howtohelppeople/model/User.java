package de.howtohelppeople.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userName;
    private String email;
    private String passwordPlain;
}