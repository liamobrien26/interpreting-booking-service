package uk.co.jlsigntech.interpreterbookingportalservice.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.User;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.RegisterUserRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out.AccountRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;
    @Mock
    private AccountRepository accountRepository;

    private RegisterUserRequest mockRegisteredUser() {
        return new RegisterUserRequest(
                "Liam",
                "O'Brien",
                "liam.obrien@co.uk",
                "Password123");
    }

    @Test
    void isEmailRegistered() {
        when(accountRepository.findByEmail(mockRegisteredUser().email())).thenReturn(Optional.empty());
        accountService.isEmailRegistered(mockRegisteredUser().email());

        verify(accountRepository, times(1)).findByEmail("liam.obrien@co.uk");
    }

    @Test
    void registerUser() {

        accountService.register(mockRegisteredUser());

        verify(accountRepository,
                times(1)).save(mockRegisteredUser(), "EMPLOYEE");
    }

    @Test
    void loginUser() {
        User user = mock(User.class);
        when(accountRepository.findByEmail(mockRegisteredUser().email()))
                .thenReturn(Optional.of(user));

        User actual = accountService.login(mockRegisteredUser().email());

        assertEquals(user, actual);
    }

    @Test
    void loginUser_noUser() {
        when(accountRepository.findByEmail(mockRegisteredUser().email()))
                .thenReturn(Optional.empty());

        User actual = accountService.login(mockRegisteredUser().email());

        assertNull(actual);
    }

}