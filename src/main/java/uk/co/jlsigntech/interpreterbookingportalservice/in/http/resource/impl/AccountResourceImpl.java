package uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.User;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.RegisterUserRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in.AccountService;
import uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource.AccountResource;

@Service
@AllArgsConstructor
public class AccountResourceImpl implements AccountResource {

    private final AccountService accountService;

    @Override
    public boolean isEmailRegistered(String email) {
        return accountService.isEmailRegistered(email);
    }

    @Override
    public void register(RegisterUserRequest registerUserRequest) {
        accountService.register(registerUserRequest);

    }

    @Override
    public User login(String email) {
        return accountService.login(email);
    }
}
