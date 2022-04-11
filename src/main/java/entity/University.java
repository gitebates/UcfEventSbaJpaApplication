package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="UNIVERSITY")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UNIVERSITY_ID")
    private UUID id;

    @Size( max = 100 )
    @Column(name="UNIVERSITY_NAME")
    private String name;

    @Column(name="UNIVERSITY_DESCRIPTION")
    @Lob // instruct Hibernate to manage this field using the PostgreSQL TEXT type
    private String description;

    @Column(name = "UNIVERSITY_STUDENT_COUNT")
    @PositiveOrZero
    private int studentCount;

    @OneToMany(mappedBy = "university")
    private List<Photo> photos;

    @OneToMany(mappedBy = "university")
    private List<Rso> rsos;

}
