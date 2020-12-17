package rs.raf.Airline.model.authDto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
