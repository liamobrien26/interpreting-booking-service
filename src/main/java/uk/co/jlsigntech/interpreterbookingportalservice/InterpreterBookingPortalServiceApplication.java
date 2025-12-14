package uk.co.jlsigntech.interpreterbookingportalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class InterpreterBookingPortalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterpreterBookingPortalServiceApplication.class, args);
    }

}
