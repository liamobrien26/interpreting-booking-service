package uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in;

import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.User;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.RegisterUserRequest;

public interface AccountService {

    boolean isEmailRegistered(String email);

    void register(RegisterUserRequest registerUserRequest);

    User login(String email);
}
