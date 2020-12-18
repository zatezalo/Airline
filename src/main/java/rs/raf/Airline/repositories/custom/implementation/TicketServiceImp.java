package rs.raf.Airline.repositories.custom.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.raf.Airline.model.Company;
import rs.raf.Airline.model.Flight;
import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.model.dto.ticketDto.TicketDto;
import rs.raf.Airline.repositories.CompanyRepository;
import rs.raf.Airline.repositories.FlightRepository;
import rs.raf.Airline.repositories.TicketRepository;
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

    @Override
    public String addTicket(TicketDto ticketDto) {
        //System.out.println(ticketDto);
        Ticket ticket = new Ticket();
        ticket.setCompany(companyRepository.findById(ticketDto.getCompanyId()).get());
        ticket.setFlight(flightRepository.findById(ticketDto.getFlightId()).get());
        ticket.setDepart(ticketDto.getDepart());
        ticket.setComeBack(ticketDto.getComeBack());
        ticketRepository.save(ticket);

        return "Created ticket";
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();

        for (Ticket ticket : ticketRepository.findAll()) {
            //ticket.setTickets(new ArrayList<Ticket>());
            tickets.add(ticket);
        }
        return tickets;
    }
}
