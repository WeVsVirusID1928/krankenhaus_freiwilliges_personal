package de.howtohelppeople.postings.repository;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "postings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostingEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String time;
    private String comment;
    private String contact;
    private String areaCode;
    @ManyToOne
    private HospitalEntity hospitalEntity;

}
