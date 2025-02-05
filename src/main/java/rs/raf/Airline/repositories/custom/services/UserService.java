package rs.raf.Airline.repositories.custom.services;

import rs.raf.Airline.model.dto.authDto.RegisterDto;

public interface UserService {
    String register(RegisterDto registerDto);
    String deleteBooking(Long id);
    String reserveBooking(Long id);
}
