package uk.co.jlsigntech.interpreterbookingportalservice.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.User;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.RegisterUserRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in.AccountService;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out.AccountRepository;

import java.util.Map;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private static final Map<String, String> DOMAIN_ROLE_MAP = Map.of(
            "jlsigntech.co.uk", "ADMIN",
            "interpreterbookingportal.co.uk", "USER",
            "default", "AGENCY"
    );


    @Override
    public boolean isEmailRegistered(String email) {
        return accountRepository.findByEmail(email).isPresent();
    }

    @Override
    public void register(RegisterUserRequest registerUserRequest) {
        String email = registerUserRequest.email().toLowerCase();
        String role = DOMAIN_ROLE_MAP.entrySet().stream().
                filter(entry -> email.endsWith("@" + entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);

        accountRepository.save(registerUserRequest, role);
    }

    @Override
    public User login(String email) {
        return accountRepository.findByEmail(email).orElse(null);
    }
}
