package rs.raf.Airline.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.Airline.model.City;

public interface CityRepository extends CrudRepository<City, Long> {
}
