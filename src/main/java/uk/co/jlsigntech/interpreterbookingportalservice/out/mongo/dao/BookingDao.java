package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Booking;

import java.util.UUID;

@Repository
public interface BookingDao extends MongoRepository<Booking, UUID> {
}
