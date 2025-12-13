package uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in;

import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.UpdateDateRequest;

public interface BookingService {

    void createBooking();

    void addDate(UpdateDateRequest updateDateRequest);
}
