package rs.raf.Airline.model.dto.ticketDto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class TicketDto {
    //@NotNull
    private Long companyId;

    //@NotNull
    private Long flightId;

    //@NotNull
    private Date depart;

    //@NotNull
    private Date comeBack;

    private Boolean oneWay;

    private Long availableCount;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public Date getComeBack() {
        return comeBack;
    }

    public void setComeBack(Date comeBack) {
        this.comeBack = comeBack;
    }

    public Boolean getOneWay() {
        return oneWay;
    }

    public void setOneWay(Boolean oneWay) {
        this.oneWay = oneWay;
    }

    public Long getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Long availableCount) {
        this.availableCount = availableCount;
    }
}
