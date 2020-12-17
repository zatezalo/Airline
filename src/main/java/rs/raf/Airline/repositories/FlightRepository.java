package rs.raf.Airline.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.Airline.model.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long> {
}
