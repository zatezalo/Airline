package rs.raf.Airline.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @OneToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "b_flight_id", referencedColumnName = "id")
    private Flight flight;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private MyUser user;

    @Column(name = "booking_count")
    private Long numberOfBookings;

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public void setNumberOfBookings(Long numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }
}
