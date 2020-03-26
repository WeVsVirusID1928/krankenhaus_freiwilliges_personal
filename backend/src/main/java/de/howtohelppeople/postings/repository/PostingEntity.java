package de.howtohelppeople.postings.repository;

import javax.persistence.*;

import lombok.*;

import static de.howtohelppeople.postings.repository.PostingEntity.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@SequenceGenerator(
        name = "default_generator",
        sequenceName = "seq_" + TABLE_NAME,
        allocationSize = 1)
@ToString(exclude = {"id"})
@EqualsAndHashCode(of = {"title","id"})
@Getter
@NoArgsConstructor(
        access = AccessLevel.PROTECTED
)
public class PostingEntity {

    public static final String TABLE_NAME = "posting";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    private Long id;

    private String title;
    private String time;
    private String comment;
    private String contact;
    private String areaCode;

//     @ManyToOne
//     @JoinColumn(name = "hospital_id", nullable = false)
//     @Setter
//     private HospitalEntity hospitalEntity;

}