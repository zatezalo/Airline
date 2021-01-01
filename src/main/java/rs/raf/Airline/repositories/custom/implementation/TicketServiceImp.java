package rs.raf.Airline.repositories.custom.implementation;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.raf.Airline.model.*;
import rs.raf.Airline.model.dto.ticketDto.AddBookingDto;
import rs.raf.Airline.model.dto.ticketDto.TicketDto;
import rs.raf.Airline.repositories.*;
import rs.raf.Airline.repositories.custom.services.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public String addTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setCompany(companyRepository.findById(ticketDto.getCompanyId()).get());
        ticket.setFlight(flightRepository.findById(ticketDto.getFlightId()).get());
        ticket.setDepart(ticketDto.getDepart());
        ticket.setComeBack(ticketDto.getComeBack());
        ticket.setAvailableCount(ticketDto.getAvailableCount());
        ticket.setOneWay(ticketDto.getOneWay());
        ticketRepository.save(ticket);

        return "Created ticket";
    }

    @Override
    public String addBooking(AddBookingDto addBookingDto) {
        Ticket ticket = ticketRepository.findById(addBookingDto.getTicketId()).get();
        MyUser user = userRepository.findByUsername(addBookingDto.getUsername());
        Booking booking = new Booking();
        booking.setFlight(ticket.getFlight());
        booking.setTicket(ticket);
        booking.setUser(user);
        booking.setAvailable(false);
        booking.setNumberOfBookings(addBookingDto.getNumberOfTickets());
        //ticket.setAvailableCount(ticket.getAvailableCount() - addBookingDto.getNumberOfTickets());

        //ticketRepository.save(ticket);
        bookingRepository.save(booking);
        return "Added Booking";
    }

    @Override
    public String editTicket(TicketDto ticketDto) {
        Ticket ticket = ticketRepository.findById(ticketDto.getTicketId()).get();
        ticket.setCompany(companyRepository.findById(ticketDto.getCompanyId()).get());
        ticket.setFlight(flightRepository.findById(ticketDto.getFlightId()).get());
        ticket.setDepart(ticketDto.getDepart());
        ticket.setComeBack(ticketDto.getComeBack());
        ticket.setAvailableCount(ticketDto.getAvailableCount());
        ticket.setOneWay(ticketDto.getOneWay());
        ticketRepository.save(ticket);
        return "Edited ticket";
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (Ticket ticket : ticketRepository.findAll()) {
            tickets.add(ticket);
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByParams() {
        return null;
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public String deletTicket(Long id) {
        ticketRepository.deleteById(id);
        return "Deleted Ticket";
    }


}
