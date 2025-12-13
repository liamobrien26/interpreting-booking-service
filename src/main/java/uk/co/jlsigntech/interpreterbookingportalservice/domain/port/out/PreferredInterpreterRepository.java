package uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out;

import org.springframework.stereotype.Repository;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Interpreter;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.PreferredInterpreterRequest;

import java.util.List;
import java.util.UUID;

@Repository
public interface PreferredInterpreterRepository {

    void deletePreferredInterpretersById(UUID interpreterId);
    void save(PreferredInterpreterRequest preferredInterpreterRequest);

    List<Interpreter> findAll();

    boolean existsByPreferredInterpreterName(String preferredInterpreterName);
}
