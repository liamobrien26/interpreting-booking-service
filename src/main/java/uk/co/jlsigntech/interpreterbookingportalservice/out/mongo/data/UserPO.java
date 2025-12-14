package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPO {

    @Id
    UUID userId;
    String firstName;
    String lastName;
    String email;
    String password;
    String role;
}
