package rs.raf.Airline.repositories.custom.services;

import rs.raf.Airline.model.authDto.RegisterDto;

public interface UserService {
    String register(RegisterDto registerDto);

}
