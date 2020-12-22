package rs.raf.Airline.model.dto.ticketDto;

import lombok.Data;

@Data
public class AddBookingDto {
    private Long ticketId;
    private String username;
    private Long numberOfTickets;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
