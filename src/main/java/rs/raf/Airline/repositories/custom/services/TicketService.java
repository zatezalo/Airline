package rs.raf.Airline.repositories.custom.services;


import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.model.dto.ticketDto.TicketDto;

import java.util.List;

public interface TicketService {
    String addTicket(TicketDto ticketDto);
    List<Ticket> getAllTickets();
}
