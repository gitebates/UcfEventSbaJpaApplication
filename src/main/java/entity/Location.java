package entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCATION_ID")
    private UUID id;

    @Size( max = 100 )
    private String name;

    private Float longitude;

    private Float latitude;

    @OneToMany(mappedBy = "EVENT_LOCATION")
    private List<Event> events;

}
