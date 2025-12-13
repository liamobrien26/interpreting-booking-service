package uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out;

import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Booking;

import java.util.UUID;

public interface BookingRepository {

    void saveOrUpdate(Booking booking);

    Booking findById(UUID id);
}
