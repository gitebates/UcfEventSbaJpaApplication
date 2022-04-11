package entity;

import lombok.*;
import models.EventType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="EVENT_LOCATION")
    private Location location;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @Basic
    @Column(name = "location_id")
    private UUID locationId;

    @Basic
    @Column(name = "university_id")
    private UUID universityId;

    @Basic
    @Column(name = "admin_id")
    private UUID adminId;

    @Basic
    @Column(name = "rso_id")
    private UUID rsoId;

    @Size(max = 150)
    private String category;

    @Basic
    @Column(name = "name")
    @Size(max = 150)
    private String name;

    @Lob // instruct Hibernate to manage this field using the PostgreSQL TEXT type
    @Column(name = "description")
    private String description;

    @Basic
    @CreationTimestamp
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "start_time")
    private Timestamp startTime;

    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;

    @Size(max = 100)
    @Column(name = "longitude")
    private String longitude;

    @Size(max = 100)
    @Column(name = "latitude")
    private String latitude;

    @Basic
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message="invalid phone number")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Email
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Basic
    @Column(name = "approved")
    private Boolean approved;


    //TODO: add Admin (Foreign Key)



}
