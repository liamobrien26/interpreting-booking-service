package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data.InterpreterPO;

import java.util.UUID;

public interface PreferredInterpreterDao extends MongoRepository<InterpreterPO, UUID> {

    void deleteByInterpreterId(UUID interpreterId);

    boolean existsByPreferredInterpreterName(String preferredInterpreterName);
}
