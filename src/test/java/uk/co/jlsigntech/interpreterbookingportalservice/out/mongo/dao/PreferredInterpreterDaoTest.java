package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data.InterpreterPO;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class PreferredInterpreterDaoTest {

    private static final UUID INTERPRETER_ID = UUID.fromString("b2dc3b5f-4a95-451f-aabe-5885a9acb48a");
    private static final String NAME = "Liam O'Brien";

    @Autowired
    private PreferredInterpreterDao preferredInterpreterDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @AfterEach
    void tearDown() {
        mongoTemplate.dropCollection("interpreterPO");
    }

    @Test
    void test_findById() {
        InterpreterPO interpreterPO = new InterpreterPO(INTERPRETER_ID, NAME);

        preferredInterpreterDao.save(interpreterPO);

        Optional<InterpreterPO> result = preferredInterpreterDao.findById(INTERPRETER_ID);

        assertEquals(Optional.of(interpreterPO),result);
    }

    @Test
    void test_deleteByInterpreterId() {
        preferredInterpreterDao.save(new InterpreterPO(INTERPRETER_ID, NAME));
        preferredInterpreterDao.deleteById(INTERPRETER_ID);

        Optional<InterpreterPO> result = preferredInterpreterDao.findById(INTERPRETER_ID);
        assertEquals(Optional.empty(),result);
    }

    @Test
    void test_existsByPreferredInterpreterName() {

        InterpreterPO interpreterPO = new InterpreterPO(INTERPRETER_ID, NAME);
        preferredInterpreterDao.save(interpreterPO);

        boolean exists = preferredInterpreterDao.existsByPreferredInterpreterName(NAME);
        boolean doesNotExists = preferredInterpreterDao.existsByPreferredInterpreterName("This is a great name");

        assertTrue(exists);
        assertFalse(doesNotExists);
    }

}