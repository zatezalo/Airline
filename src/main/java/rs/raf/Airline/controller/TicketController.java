package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.model.dto.ticketDto.TicketDto;
import rs.raf.Airline.repositories.FlightRepository;
import rs.raf.Airline.repositories.custom.services.TicketService;
import rs.raf.Airline.repositories.custom.services.UserService;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    //@CrossOrigin
    @PostMapping("/addTicket")
    public String addTicket(@RequestBody TicketDto ticketDto) {

        return ticketService.addTicket(ticketDto);
    }

    @GetMapping("/getAllTickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
}
