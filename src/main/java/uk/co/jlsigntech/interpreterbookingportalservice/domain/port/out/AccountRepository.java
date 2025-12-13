package uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out;

import org.springframework.stereotype.Repository;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.User;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.RegisterUserRequest;

import java.util.Optional;

@Repository
public interface AccountRepository {

    Optional<User> findByEmail(String email);

    void update(User user);

    void save(RegisterUserRequest registerUserRequest, String role);
}
