package sergey.goit.entities;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @SequenceGenerator(name = "clientgenerator", sequenceName = "clientgenerator", allocationSize = 1, initialValue = 11)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientgenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(200)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "clientId")
    private Set<Ticket> tickets;

    public Client() {
    }


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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + " '}";
    }
}