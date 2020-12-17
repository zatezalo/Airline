package rs.raf.Airline.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id")
    private City origin;

    @OneToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private City destination;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
