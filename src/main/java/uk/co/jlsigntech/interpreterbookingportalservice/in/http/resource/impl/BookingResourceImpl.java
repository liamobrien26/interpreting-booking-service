package uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource.impl;

import lombok.AllArgsConstructor;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.UpdateDateRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in.BookingService;
import uk.co.jlsigntech.interpreterbookingportalservice.in.http.resource.BookingResource;

@AllArgsConstructor
public class BookingResourceImpl implements BookingResource {

    private final BookingService bookingService;

    @Override
    public String booking() {
        bookingService.createBooking();
        return "";
    }

    @Override
    public void updateDate(UpdateDateRequest updateDateRequest) {
        bookingService.addDate(updateDateRequest);
    }
}
