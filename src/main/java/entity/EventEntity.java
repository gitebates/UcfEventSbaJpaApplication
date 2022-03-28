package entity;

import lombok.*;
import models.EventType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

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

    @Basic
    @Column(name = "name")
    private String name;

    @Lob // instruct Hibernate to manage this field using the PostgreSQL TEXT type
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "start_time")
    private Timestamp startTime;

    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;

    @Basic
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






}
