package uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.User;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.RegisterUserRequest;

@RestController
public interface AccountResource {

    @GetMapping("isEmailRegistered")
    boolean isEmailRegistered(@RequestParam String email);

    @PostMapping("register/temp")
    void register(@RequestBody RegisterUserRequest registerUserRequest);

    @GetMapping("login")
    User login(@RequestParam String email);
}
