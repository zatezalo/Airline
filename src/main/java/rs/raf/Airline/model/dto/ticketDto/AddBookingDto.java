package rs.raf.Airline.model.dto.ticketDto;

import lombok.Data;

@Data
public class AddBookingDto {
    private Long ticketId;
    private String username;
    private Long numberOfTickets;
}
