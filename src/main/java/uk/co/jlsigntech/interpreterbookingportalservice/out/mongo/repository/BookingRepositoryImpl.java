package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.repository;

import lombok.AllArgsConstructor;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.model.Booking;
import uk.co.jlsigntech.interpreterbookingportalservice.domain.port.out.BookingRepository;
import uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.dao.BookingDao;

import java.util.UUID;

@AllArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {

    private final BookingDao bookingDao;

    @Override
    public void saveOrUpdate(Booking booking) {
        bookingDao.save(booking);
    }

    @Override
    public Booking findById(UUID id) {
        return bookingDao.findById(id).orElse(null);
    }
}
