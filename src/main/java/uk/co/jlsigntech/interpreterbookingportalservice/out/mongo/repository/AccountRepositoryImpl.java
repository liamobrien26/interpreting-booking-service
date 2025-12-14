package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.User;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.RegisterUserRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out.AccountRepository;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao.AccountDao;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data.UserPO;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountDao accountDao;

    @Override
    public Optional<User> findByEmail(String email) {
        return accountDao.findByEmail(email).map(
                user -> new User(
                        user.getUserId(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getRole()
                )
        );
    }

    @Override
    public void update(User user) {
        String password = accountDao.findByEmail(user.email()).map(UserPO::getPassword).orElseThrow();
        accountDao.save(
                new UserPO(
                        user.userId(),
                        password,
                        user.firstName(),
                        user.lastName(),
                        user.email(),
                        user.role()
                )
        );
    }

    @Override
    public void save(RegisterUserRequest registerUserRequest, String role) {
        accountDao.save(
                new UserPO(
                        UUID.randomUUID(),
                        registerUserRequest.firstName(),
                        registerUserRequest.lastName(),
                        registerUserRequest.email(),
                        registerUserRequest.password(),
                        role));
    }

}
