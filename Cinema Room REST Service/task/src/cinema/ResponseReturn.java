package cinema;

public class ResponseReturn {
    private Seat returnedTicket;

    public ResponseReturn(Seat seat) {
        this.returnedTicket = seat;
    }

    public ResponseReturn() {

    }

    public Seat getReturnedTicket() {
        return this.returnedTicket;
    }
}
