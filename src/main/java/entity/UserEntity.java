package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.UserLevel;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private int id;

    @NotNull
    @Column(unique=true)
    private String username;

    @NotNull
    @Max(value = 500)
    private String password;

    @NotNull
    @Max(value = 150)
    private String firstName;

    @NotNull
    @Max(value = 150)
    private String lastName;

    @NotNull
    @Email
    @Max(value = 254)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserLevel userLevel;

    @Basic
    @Column(name = "university_id")
    private int universityId;

    @Basic
    @Column(name = "rso_id")
    private UUID rsoId;

    @Column(name = "date_joined")
    @CreationTimestamp
    private Timestamp dateJoined;


    @Column(name = "last_login")
    @UpdateTimestamp
    private Timestamp lastLogin;


}
