package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.model.dto.ticketDto.AddBookingDto;
import rs.raf.Airline.model.dto.ticketDto.SearchDto;
import rs.raf.Airline.model.dto.ticketDto.TicketDto;
import rs.raf.Airline.repositories.custom.services.TicketService;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/getAllTickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping("/searchTickets")
    public List<Ticket> searchTickets(@RequestBody SearchDto searchDto) {
        System.out.println("radi");
        System.out.println(searchDto.getDestination());
        System.out.println(searchDto.getOrigin());
        System.out.println(searchDto.getDepart());
        System.out.println(searchDto.getComeBack());
        return null;
        //return ticketService.getTicketsByParams();
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
        //System.out.println(addBookingDto);
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
