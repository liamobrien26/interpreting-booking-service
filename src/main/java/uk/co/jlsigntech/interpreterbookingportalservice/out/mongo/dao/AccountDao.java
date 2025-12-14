package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data.UserPO;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountDao extends MongoRepository<UserPO, UUID> {

    Optional<UserPO> findByEmail(String email);
}
