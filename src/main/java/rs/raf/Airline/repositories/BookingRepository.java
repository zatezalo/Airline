package rs.raf.Airline.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.Airline.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
