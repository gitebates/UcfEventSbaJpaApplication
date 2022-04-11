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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
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

//    //TODO: many-to-many
//    @Enumerated(EnumType.STRING)
//    private Set<UserLevel> userLevel;

    @Basic
    @Column(name = "university_id")
    private int universityId;

    @ManyToMany(mappedBy="user")
    private Set<Rso> rsos = new HashSet<>();

    @Column(name = "date_joined")
    @CreationTimestamp
    private Timestamp dateJoined;

    @Column(name = "last_login")
    @UpdateTimestamp
    private Timestamp lastLogin;

    @Column(name = "USER_COMMENTS")
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;



}
