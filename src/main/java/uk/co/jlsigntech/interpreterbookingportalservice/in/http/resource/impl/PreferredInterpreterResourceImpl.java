package uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Interpreter;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.PreferredInterpreterRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in.PreferredInterpreterService;
import uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource.PreferredInterpreterResource;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PreferredInterpreterResourceImpl implements PreferredInterpreterResource {

    private final PreferredInterpreterService preferredInterpreterService;

    @Override
    public boolean doesInterpreterNameExists(String preferredInterpreterName) {
        return preferredInterpreterService.doesInterpreterNameExists(preferredInterpreterName);
    }

    @Override
    public void addPreferredInterpreterName(PreferredInterpreterRequest preferredInterpreterRequest) {
        preferredInterpreterService.addPreferredInterpreterName(preferredInterpreterRequest);
    }

    @Override
    public List<Interpreter> getAllPreferredInterpreterNames() {
        return preferredInterpreterService.getAllPreferredInterpreterNames();
    }

    @Override
    public void deletePreferredInterpreterName(UUID interpreterId) {
        preferredInterpreterService.deletePreferredInterpreterName(interpreterId);
    }
}
