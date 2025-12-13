package uk.co.jlsigntech.interpreterbookingportalservice.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Interpreter;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.PreferredInterpreterRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in.PreferredInterpreterService;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out.PreferredInterpreterRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PreferredInterpreterImpl implements PreferredInterpreterService {

    private PreferredInterpreterRepository preferredInterpreterRepository;

    @Override
    public boolean doesInterpreterNameExists(String preferredInterpreterName) {
        return preferredInterpreterRepository.existsByPreferredInterpreterName(preferredInterpreterName);
    }

    @Override
    public void addPreferredInterpreter(PreferredInterpreterRequest preferredInterpreterRequest) {
        preferredInterpreterRepository.save(preferredInterpreterRequest);

    }

    @Override
    public List<Interpreter> getAllPreferredInterpreters() {
        return preferredInterpreterRepository.findAll();
    }

    @Override
    public void removePreferredInterpreter(UUID interpreterId) {
        preferredInterpreterRepository.deletePreferredInterpretersById(interpreterId);
    }
}
