package uk.co.jlsigntech.interpreterbookingportalservice.domain.service;

import lombok.AllArgsConstructor;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Booking;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.UpdateDateRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.in.BookingService;

import java.util.UUID;

@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Override
    public void createBooking() {
        bookingRepository.saveOrUpdate(Booking.builder()
                .id(UUID.randomUUID())
                .build());
    }

    @Override
    public void addDate(UpdateDateRequest updateDateRequest) {
        Booking booking = bookingRepository.findById(updateDateRequest.bookingId()).toBuilder()
                .date(updateDateRequest.date())
                        .build();

        bookingRepository.saveOrUpdate(booking);
    }
}
