package rs.raf.Airline.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.Airline.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
