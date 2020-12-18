package rs.raf.Airline.repositories.custom.services;

import rs.raf.Airline.model.Company;
import rs.raf.Airline.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();
}
