package entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder( toBuilder = true )
@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "photo" )
public class PhotoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id" )
    private UUID id;

    @Column( name= "university_name" )
    @Size( max = 100 )
    private String universityName;

    @Size( max = 100 )
    private String path;


}
