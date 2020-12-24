package rs.raf.Airline.model.dto.companyDto;

import lombok.Data;
import rs.raf.Airline.model.Ticket;

import java.util.List;

@Data
public class CompanyDto {
    private String name;
    private List<Ticket> tickets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
