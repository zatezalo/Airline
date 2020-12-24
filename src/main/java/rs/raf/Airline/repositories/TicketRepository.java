package rs.raf.Airline.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;
import rs.raf.Airline.model.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Query("SELECT t from Ticket t where (:originId is null or t.flight.origin.id = :originId) and " +
            "(:destinationId is null or t.flight.destination.id = :destinationId) and " +
            "(:comeBack is null or t.comeBack = :comeBack) and (:depart is null or t.depart = :depart) ")
    List<Ticket> findAllByFlight_Origin_IdAndFlight_Destination_IdAndComeBackAndAndDepart
            (@RequestParam("originId")Long originId, @RequestParam("destinationId")Long destinationId,
             @RequestParam("comeBack") Date comeBack, @RequestParam("depart") Date depart);

    List<Ticket> findAllByCompany_Id(@RequestParam("companyId") Long companyId);

}
