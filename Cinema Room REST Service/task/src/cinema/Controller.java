package cinema;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final Orders orders = Orders.getInstance();
    private final Seats seats = new Seats();

    @GetMapping("/seats")
    public Seats getSeats() {
        return this.seats;
    }

    @PostMapping("/purchase")
    public Order purchase(@RequestBody Seat requestedSeat) {
        Seat[] availableSeats = this.seats.getAvailableSeats();
        int requestedRow = requestedSeat.getRow();
        int requestedColumn = requestedSeat.getColumn();
        if (
            requestedRow > this.seats.getTotalRows() ||
            requestedRow < 1 ||
            requestedColumn > this.seats.getTotalColumns() ||
            requestedColumn < 1
        ) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
        Seat seat = this.seats.findSeat(requestedRow, requestedColumn);
        if (orders.checkTicket(seat)) {
            throw new PurchaseException("The ticket has been already purchased!");
        }

        return orders.purchase(seat);
    }

    @PostMapping("/return")
    public ResponseReturn handleReturn(@RequestBody RequestReturn request) {
        Order order = this.orders.getOrderByToken(request.getToken());
        if (order != null) {
            this.orders.deleteOrder(order);
            return new ResponseReturn(order.getTicket());
        }

        throw new PurchaseException("Wrong token!");
    }

    @PostMapping("/stats")
    public Stats handleStats(@RequestParam(defaultValue = "") String password) {
        if ("super_secret".equals(password)) {
            return new Stats(this.orders, this.seats);
        }

        throw new StatsException("The password is wrong!");
    }
}
