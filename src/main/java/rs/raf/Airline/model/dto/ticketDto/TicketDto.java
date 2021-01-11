package rs.raf.Airline.model.dto.ticketDto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class TicketDto {
    private Long ticketId;
    private Long companyId;
    private Long flightId;
    private Date depart;
    private Date comeBack;
    private Boolean oneWay;
    private Long availableCount;
}
