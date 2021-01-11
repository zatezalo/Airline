package rs.raf.Airline.model.dto.companyDto;

import lombok.Data;
import rs.raf.Airline.model.Ticket;

import java.util.List;

@Data
public class CompanyDto {
    private String name;
    private List<Ticket> tickets;
}
