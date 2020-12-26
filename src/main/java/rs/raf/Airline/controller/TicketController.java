package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.model.dto.ticketDto.AddBookingDto;
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

    @GetMapping("/getAllTickets")
    public List<Ticket> getAllTickets() {
        /*
        da prosledimo parameter od niza svih ovih tiketa vratim
        */
        return ticketService.getAllTickets();
    }

    @GetMapping("/getTicket/{id}")
    public Ticket getTicket(@PathVariable("id") Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/addTicket")
    public String addTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.addTicket(ticketDto);
    }

    @PostMapping("/addBooking")
    public String addBooking(@RequestBody AddBookingDto addBookingDto) {
        return ticketService.addBooking(addBookingDto);
    }

    @PutMapping("/editTicket")
    public String editTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.editTicket(ticketDto);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable("id") Long id){
        return ticketService.deletTicket(id);
    }
}
