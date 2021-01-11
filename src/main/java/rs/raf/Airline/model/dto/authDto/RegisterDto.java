package rs.raf.Airline.model.dto.authDto;

import com.sun.istack.NotNull;
import lombok.Data;
import rs.raf.Airline.model.UserType;

@Data
public class RegisterDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private UserType userType;
}
