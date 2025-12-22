package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.User;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.RegisterUserRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in.AccountService;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao.AccountDao;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data.UserPO;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class AccountResourceImplTest {

    private static final String EMAIL = "liam.obrien@co.uk";
    private static final UUID USER_ID = UUID.randomUUID();
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String ROLE = "role";

    @Mock
    private AccountDao accountDao;
    @Mock
    private AccountService accountService;
    @InjectMocks
    private AccountRepositoryImpl accountRepository;

    @Test
    public void test_getByEmail() {
        User expected = new User(
                USER_ID,
                PASSWORD,
                FIRST_NAME,
                LAST_NAME,
                EMAIL,
                ROLE
        );
        UserPO foundPO = new UserPO(USER_ID,
                FIRST_NAME,
                LAST_NAME,
                EMAIL,
                PASSWORD,
                ROLE);
        when(accountDao.findByEmail(EMAIL)).thenReturn(Optional.of(foundPO));

        Optional<User> actual = accountRepository.findByEmail(EMAIL);

        assertEquals(Optional.of(expected), actual);
    }

    @Test
    public void test_registeringNewUser() {
    }

    @Test
    public void testIfEmailIsRegistered() {

        User user = new User(
                UUID.randomUUID(),
                "Password123",
                "Donald",
                "Trump",
                "donald.trump@co.uk",
                "EMPLOYEE");

        accountService.isEmailRegistered(user.email());

        Optional<User> usersRegistered = accountRepository.findByEmail("donald.trump@dwp.gov.uk");

        Assertions.assertTrue(usersRegistered.isPresent());
    }

    @Test
    public void testIfEmailIsNotRegisteredWhenEmailIsNull() {
        User user = new User(
                UUID.randomUUID(),
                "Password123",
                "Harry",
                "Potter",
                null,
                "DWP_EMPLOYEE");

        accountService.isEmailRegistered(user.email());

        Optional<User> usersRegistered = accountRepository.findByEmail(null);

        Assertions.assertTrue(usersRegistered.isPresent());
    }

    @Test
    public void testIfEmailIsNotRegisteredWhenEmailIsEmpty() {
        User user = new User(
                UUID.randomUUID(),
                "Password123",
                "Harry",
                "Potter",
                "",
                "DWP_EMPLOYEE");

        accountService.isEmailRegistered(user.email());

        Optional<User> usersRegistered = accountRepository.findByEmail("");

        Assertions.assertTrue(usersRegistered.isPresent());
    }

    @Test
    public void testIfUserAttemptsToRegisterGetValidated() {

        RegisterUserRequest mockedUser = new RegisterUserRequest(
                "Harry",
                "Potter",
                "harry.potter@dwp.gov.uk",
                "Password123");

        accountService.register(mockedUser);
        Optional<User> usersRegistered = accountRepository.findByEmail(mockedUser.email());
        Assertions.assertTrue(usersRegistered.isPresent());
    }

    @Test
    public void testIfUserAttemptsToRegisterGetInvalid() {
        RegisterUserRequest mockedUser = new RegisterUserRequest(
                "Harry potter",
                "Ron Weasley",
                "harrypotter@gov.uk",
                "wrongPPassword123");

        accountService.register(mockedUser);
        Optional<User> usersRegistered = accountRepository.findByEmail(mockedUser.email());
        Assertions.assertFalse(usersRegistered.isPresent());
    }

    @Test
    public void validate_ifRegisteredUserIsAbleToLogin() {
        User user = new User(
                UUID.randomUUID(),
                "Password123",
                "Donald",
                "Trump",
                "donald.trump@dwp.gov.uk",
                "DWP_EMPLOYEE");

        accountService.login(user.email());
        Optional<User> usersRegistered = accountRepository.findByEmail(user.email());
        Assertions.assertTrue(usersRegistered.isPresent());
    }

}