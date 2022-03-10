package cinema;

import java.util.Map;
import java.util.HashMap;

public class Orders {
    private final Map<Integer, Order> orders = new HashMap<>();

    private Orders() {

    }

    public static int getOrderKey(Seat seat) {
        return seat.getRow() * 9 + seat.getColumn();
    }

    public Order purchase(Seat ticket) {
        Order order = new Order(ticket);
        this.orders.put(Orders.getOrderKey(ticket), order);
        return order;
    }

    public boolean checkTicket(Seat ticket) {
        return orders.containsKey(Orders.getOrderKey(ticket));
    }

    public Order getOrderByToken(String token) {
        for (Order order : this.orders.values()) {
            if (order.getToken().toString().equals(token)){
                return order;
            }
        }

        return null;
    }

    public void deleteOrder(Order order) {
        Seat ticket = order.getTicket();
        this.orders.remove(Orders.getOrderKey(ticket));
    }

    public Map<Integer, Order> getOrders() {
        return this.orders;
    }

    private static class SingletonHolder {
        public static final Orders HOLDER_INSTANCE = new Orders();
    }

    public static Orders getInstance() {
        return Orders.SingletonHolder.HOLDER_INSTANCE;
    }
}
