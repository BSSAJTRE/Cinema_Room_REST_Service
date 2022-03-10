package cinema;

import java.util.Map;

public class Stats {
    private int currentIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;

    public Stats() {

    }

    public Stats(Orders orders, Seats seats) {
        Map<Integer, Order> ordersMap = orders.getOrders();
        this.numberOfPurchasedTickets = ordersMap.size();
        this.numberOfAvailableSeats = seats.getAvailableSeats().length - this.numberOfPurchasedTickets;
        int currentIncome = 0;
        for (Order order : ordersMap.values()) {
            currentIncome += order.getTicket().getPrice();
        }
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return this.numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return this.numberOfPurchasedTickets;
    }

    public int getCurrentIncome() {
        return this.currentIncome;
    }
}
