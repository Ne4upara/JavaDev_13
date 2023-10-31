package sergey.goit.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "ticket")
public class Ticket {

    @Id
    @SequenceGenerator(name = "ticketgenerator", sequenceName = "ticketgenerator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketgenerator")
    @Column (name = "id")
    private Long id;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created_at;

    public Ticket(){
        this.created_at = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_planet_id", referencedColumnName = "id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_planet_id", referencedColumnName = "id", nullable = false)
    private Planet toPlanet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Planet getFromplanet() {
        return fromPlanet;
    }

    public void setFromplanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public Planet getToPlanet() {
        return toPlanet;
    }

    public void setToPlanet(Planet toPlanet) {
        this.toPlanet = toPlanet;
    }
}