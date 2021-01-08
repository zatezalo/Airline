package rs.raf.Airline.model.dto.ticketDto;

import lombok.Data;

import java.util.Date;

@Data
public class SearchDto {
    private Long destination;
    private Long origin;
    private Date comeBack;
    private Date depart;

    public Long getDestination() {
        return destination;
    }

    public Long getOrigin() {
        return origin;
    }

    public Date getComeBack() {
        return comeBack;
    }

    public Date getDepart() {
        return depart;
    }
}
