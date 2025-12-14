package uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in;

import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Interpreter;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.PreferredInterpreterRequest;

import java.util.List;
import java.util.UUID;

public interface PreferredInterpreterService {

    boolean doesInterpreterNameExists(String preferredInterpreterName);

    void addPreferredInterpreterName(PreferredInterpreterRequest preferredInterpreterRequest);

    List<Interpreter> getAllPreferredInterpreterNames();

    void deletePreferredInterpreterName(UUID interpreterId);
}
