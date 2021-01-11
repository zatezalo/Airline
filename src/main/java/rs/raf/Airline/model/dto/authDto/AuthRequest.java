package rs.raf.Airline.model.dto.authDto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
