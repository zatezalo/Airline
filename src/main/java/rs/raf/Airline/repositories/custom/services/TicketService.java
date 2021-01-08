package rs.raf.Airline.repositories.custom.services;


import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.model.dto.ticketDto.AddBookingDto;
import rs.raf.Airline.model.dto.ticketDto.SearchDto;
import rs.raf.Airline.model.dto.ticketDto.TicketDto;

import java.util.List;

public interface TicketService {
    String addTicket(TicketDto ticketDto);
    String addBooking(AddBookingDto addBookingDto);
    String editTicket(TicketDto ticketDto);
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsByParams(SearchDto searchDto);
    Ticket getTicketById(Long id);
    String deletTicket(Long id);
}
