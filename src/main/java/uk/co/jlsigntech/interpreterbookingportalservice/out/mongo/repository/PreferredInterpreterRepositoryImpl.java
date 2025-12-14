package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Interpreter;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.PreferredInterpreterRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out.PreferredInterpreterRepository;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao.PreferredInterpreterDao;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data.InterpreterPO;

import java.util.List;
import java.util.UUID;

@Service //Knows how to get user info and tell Spring Security about it
@RequiredArgsConstructor
public class PreferredInterpreterRepositoryImpl implements PreferredInterpreterRepository {

    private final PreferredInterpreterDao preferredInterpreterDao; // Repository to fetch user data from database

    @Override
    public void deletePreferredInterpreterById(UUID interpreterId) {
        preferredInterpreterDao.deleteByInterpreterId(interpreterId);
    }

    @Override
    public void save(PreferredInterpreterRequest preferredInterpreterRequest) {
        preferredInterpreterDao.save(
                new InterpreterPO(
                        UUID.randomUUID(),
                        preferredInterpreterRequest.preferredInterpreterName()));
    }

    @Override
    public List<Interpreter> findAll() {
        return preferredInterpreterDao.findAll().stream()
                .map(interpreterPO -> new Interpreter(interpreterPO.getInterpreterId(), interpreterPO.getPreferredInterpreterName())).toList();
    }

    @Override
    public boolean existsByPreferredInterpreterName(String preferredInterpreterName) {
        return preferredInterpreterDao.existsByPreferredInterpreterName(preferredInterpreterName);
    }

}