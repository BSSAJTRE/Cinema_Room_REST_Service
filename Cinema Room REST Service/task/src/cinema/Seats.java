package cinema;

public class Seats {
    private final int totalRows = 9;
    private final int totalColumns = 9;
    private final Seat[] seats = new Seat[this.totalColumns * this.totalRows];

    public int getTotalColumns() {
        return totalColumns;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public static void setSeatPrice(Seat seat) {
        seat.setPrice(seat.getRow() < 5 ? 10 : 8);
    }

    public Seat[] getAvailableSeats(){
        return this.seats;
    }

    public Seats() {
        for (int i = 0; i < this.totalRows; i++) {
            for (int j = 0; j < this.totalColumns; j++) {
                Seat seat = new Seat(i + 1, j + 1);
                Seats.setSeatPrice(seat);

                this.seats[i * 9 + j] = seat;
            }
        }
    }

    public Seat findSeat(int row, int column) {
        return this.seats[(row - 1) * 9 + column - 1];
    }
}
