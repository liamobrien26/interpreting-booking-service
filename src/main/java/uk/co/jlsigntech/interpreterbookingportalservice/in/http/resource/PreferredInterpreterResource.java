package uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Interpreter;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.PreferredInterpreterRequest;

import java.util.List;
import java.util.UUID;

@RestController
public interface PreferredInterpreterResource {

    @GetMapping("/doesInterpreterNameExists")
    boolean doesInterpreterNameExists(@RequestParam String preferredInterpreterName);

    @PostMapping("/preferred-interpreter-name")
    void addPreferredInterpreterName(@RequestBody PreferredInterpreterRequest preferredInterpreterRequest);

    @GetMapping("/getAllPreferredInterpreterNames")
    List<Interpreter> getAllPreferredInterpreterNames();

    @DeleteMapping("/deletePreferredInterpreterName")
    void deletePreferredInterpreterName(@RequestParam UUID interpreterId);
}
