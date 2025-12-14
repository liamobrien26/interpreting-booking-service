package uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.UpdateDateRequest;

@Controller
public interface BookingResource {

    @GetMapping
    String booking();

    @PostMapping
    void updateDate(@RequestBody UpdateDateRequest updateDateRequest);


    //todo: Update next field, get booking, find all user id
}
