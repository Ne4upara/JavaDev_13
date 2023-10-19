package sergey.goit.entities;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table (name = "planet")
public class Planet {

    @Id
    @Column (name = "id", nullable = false)
    private String id;


    @Column (name = "name", columnDefinition = "VARCHAR(500)", nullable = false)
    private String name;

    @OneToMany (mappedBy = "fromPlanet")
    private Set<Ticket> fromTickets;

    @OneToMany (mappedBy = "toPlanet")
    private Set<Ticket> toPlanet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ticket> getFromTickets() {
        return fromTickets;
    }

    public void setFromTickets(Set<Ticket> fromTickets) {
        this.fromTickets = fromTickets;
    }

    public Set<Ticket> getToPlanet() {
        return toPlanet;
    }

    public void setToPlanet(Set<Ticket> toPlanet) {
        this.toPlanet = toPlanet;
    }
}
