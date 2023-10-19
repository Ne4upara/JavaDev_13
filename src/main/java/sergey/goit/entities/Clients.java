package sergey.goit.entities;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table (name = "clients")
public class Clients {

    @Id
    @SequenceGenerator(name = "clientgenerator", sequenceName = "clientgenerator", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "clientgenerator")
    @Column (name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(200)", nullable = false)
    private String name;

    @OneToMany (mappedBy = "clientId")
    private Set<Ticket> tickets;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
