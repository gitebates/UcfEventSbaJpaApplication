package entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RSO")
public class Rso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Size(max = 255)
    private String name;

    @Lob // instruct Hibernate to manage this field using the PostgreSQL TEXT type
    private String description;

    private UUID universityId;

    private UUID adminId;

    @PositiveOrZero
    private int totalStudents;

    private Boolean status = false;

    @ManyToMany
    @JoinTable(name = "RSO_USERS", joinColumns = @JoinColumn(name="RSO_ID"), inverseJoinColumns = @JoinColumn(name="USER_ID"))
    private Set<User> users = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "UNIVERISTY_RSO")
    private University university;

}
