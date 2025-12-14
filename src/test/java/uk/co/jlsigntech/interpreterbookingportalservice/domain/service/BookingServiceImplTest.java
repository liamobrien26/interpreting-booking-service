package uk.co.jlsigntech.interpreterbookingportalservice.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Booking;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request.UpdateDateRequest;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out.BookingRepository;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {

    private static final UUID ID = UUID.randomUUID();
    private static final LocalDate NOW = LocalDate.now();

    @Mock
    private BookingRepository bookingRepository;
    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void createBooking() {
        Booking booking = new Booking(ID, null);

        try (MockedStatic<UUID> uuidMocked = Mockito.mockStatic(UUID.class)) {
            uuidMocked.when(UUID::randomUUID).thenReturn(ID);

            bookingService.createBooking();
        }


        verify(bookingRepository, times(1)).saveOrUpdate(booking);
    }

    @Test
    void addDateToBooking() {
        Booking expectedBooking = new Booking(ID, NOW);

        Booking bookingToUpdate = new Booking(ID, null);
        when(bookingRepository.findById(ID)).thenReturn(bookingToUpdate);

        bookingService.addDate(new UpdateDateRequest(ID, NOW));

        verify(bookingRepository, times(1)).saveOrUpdate(expectedBooking);
    }

}