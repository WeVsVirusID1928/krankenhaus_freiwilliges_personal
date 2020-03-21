package de.howtohelppeople.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    private Long id;

    private String userName;
    private String email;
    private String passwordHash;
    private String lastLogin;
}
