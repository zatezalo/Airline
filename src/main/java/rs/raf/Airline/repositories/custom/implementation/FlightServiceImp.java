package rs.raf.Airline.repositories.custom.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.raf.Airline.model.Company;
import rs.raf.Airline.model.Flight;
import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.repositories.CompanyRepository;
import rs.raf.Airline.repositories.FlightRepository;
import rs.raf.Airline.repositories.custom.services.FlightService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImp implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<Flight>();

        for (Flight flight : flightRepository.findAll()) {
            flights.add(flight);
        }
        return flights;
    }
}
