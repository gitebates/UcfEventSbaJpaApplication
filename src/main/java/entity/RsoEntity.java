package entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rso")
public class RsoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    private String name;

    @Lob // instruct Hibernate to manage this field using the PostgreSQL TEXT type
    private String description;

    private UUID universityId;

    private UUID adminId;

    @PositiveOrZero
    private int totalStudents;

    private Boolean status = false;




}
