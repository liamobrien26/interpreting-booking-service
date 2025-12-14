package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data.UserPO;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class AccountDaoTest {

    private static final UUID USER_ID = UUID.randomUUID();
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @AfterEach
    void tearDown() {
        mongoTemplate.dropCollection("userPO");
    }

    @Test
    void findById() {
        UserPO userPO = new  UserPO(USER_ID,
                "First name",
                "last name",
                "email",
                "password",
                "role");

        accountDao.save(userPO);

        Optional<UserPO> actual = accountDao.findById(USER_ID);

        assertEquals(Optional.of(userPO), actual);
    }

    @Test
    void findByEmail() {
        UserPO userPO = new UserPO(USER_ID,
                "first name",
                "last name",
                "email",
                "password",
                "role");

        accountDao.save(userPO);
        Optional<UserPO> actual = accountDao.findByEmail("email");
        assertEquals(Optional.of(userPO), actual);
    }

}