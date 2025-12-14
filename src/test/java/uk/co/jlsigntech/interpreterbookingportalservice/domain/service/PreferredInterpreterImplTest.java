package uk.co.jlsigntech.interpreterbookingportalservice.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Interpreter;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.PreferredInterpreterRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out.PreferredInterpreterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PreferredInterpreterImplTest {

    @InjectMocks
    private PreferredInterpreterImpl preferredInterpreterImpl;
    @Mock
    private PreferredInterpreterRepository preferredInterpreterRepository;


    @Test
    public void validate_ifPreferredInterpreterNameExists() {
        String preferredInterpreterName = "Liam O'Brien";

        preferredInterpreterImpl.doesInterpreterNameExists(preferredInterpreterName);

        verify(preferredInterpreterRepository, times(1)).existsByPreferredInterpreterName(preferredInterpreterName);
    }

    @Test
    void validate_ifPreferredInterpreterGetsAddedAndSaves() {
        PreferredInterpreterRequest preferredInterpreterName = new PreferredInterpreterRequest("Donald Trump");

        preferredInterpreterImpl.addPreferredInterpreterName(preferredInterpreterName);
        verify(preferredInterpreterRepository, times(1)).save(preferredInterpreterName);
    }

    @Test
    void validate_getAllPreferredInterpreterNames() {

        List<Interpreter> expectedListOfPreferredInterpreters = List.of(
                new Interpreter(UUID.fromString("9d44ef9a-5ff8-471e-bafd-105aee824768"), "Blaine Reeves"),
                new Interpreter(UUID.fromString("38cb67c8-e301-4f1a-a50c-8570534ed19b"), "Alexa Diaz"),
                new Interpreter(UUID.fromString("38cb67c8-e301-4f1a-a50c-8570534ed19b"), "Mohammad Valencia"),
                new Interpreter(UUID.fromString("c3ec65b3-1695-4e23-8d6c-2d2bd5bd18e9"), "Mohammad Valencia"),
                new Interpreter(UUID.fromString("d39d040c-66da-462c-ad85-d8d25fd6ffb6"), "Miranda Kaiser"));

        when(preferredInterpreterRepository.findAll()).thenReturn(expectedListOfPreferredInterpreters);
        assertEquals(expectedListOfPreferredInterpreters, preferredInterpreterImpl.getAllPreferredInterpreterNames());
        assertEquals(5, preferredInterpreterImpl.getAllPreferredInterpreterNames().size());
    }

    @Test
    void testFindAllPreferredInterpreterNames_whenNoPreferredInterpreterFound() {
        when(preferredInterpreterRepository.findAll()).thenReturn(new ArrayList<>());
        List<Interpreter> interpreterList = preferredInterpreterImpl.getAllPreferredInterpreterNames();
        assertEquals(0, interpreterList.size());
    }


    @Test
    void validate_deletePreferredInterpreter() {
        UUID interpreterId = UUID.randomUUID();

        preferredInterpreterImpl.deletePreferredInterpreterName(interpreterId);

        verify(preferredInterpreterRepository, times(1)).deletePreferredInterpreterById(interpreterId);
    }

}