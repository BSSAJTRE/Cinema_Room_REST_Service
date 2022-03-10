package cinema;

import java.util.UUID;

public class Order {
    private final UUID token = UUID.randomUUID();
    private Seat ticket;

    public Order(Seat seat) {
        this.ticket = seat;
    }

    public Order() {

    }

    public UUID getToken() {
        return this.token;
    }

    public Seat getTicket() {
        return this.ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}
