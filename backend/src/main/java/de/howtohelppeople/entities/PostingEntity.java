package de.howtohelppeople.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "postings")
@Getter
@Setter
public class PostingEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String time;
    private String comment;
    private String contact;
    private String areaCode;
}
