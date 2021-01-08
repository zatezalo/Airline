package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.exeptions.ApiRequestException;
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
        return ticketService.getTicketsByParams(searchDto);
    }

    @GetMapping("/getTicket/{id}")
    public Ticket getTicket(@PathVariable("id") Long id) {
        return ticketService.getTicketById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addTicket")
    public String addTicket(@RequestBody TicketDto ticketDto) {
        if(ticketDto.getFlightId().equals(null) || ticketDto.getFlightId() < 0)
            throw new ApiRequestException("The flight can't be null!");

        if(ticketDto.getCompanyId().equals(null) || ticketDto.getCompanyId() < 0)
            throw new ApiRequestException("The company can't be null!");

        if(ticketDto.getAvailableCount().equals(null) || ticketDto.getAvailableCount() < 5)
            throw new ApiRequestException("The Available Tickets can't be les then 5!");

        if(ticketDto.getComeBack().before(ticketDto.getDepart()))
            throw new ApiRequestException("Come Back date must be after depart date!");

        return ticketService.addTicket(ticketDto);
    }

    @PostMapping("/addBooking")
    public String addBooking(@RequestBody AddBookingDto addBookingDto) {
        //System.out.println(addBookingDto);
        return ticketService.addBooking(addBookingDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editTicket")
    public String editTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.editTicket(ticketDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable("id") Long id){
        return ticketService.deletTicket(id);
    }
}
