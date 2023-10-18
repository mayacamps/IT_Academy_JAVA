package n3ex01;

import java.util.ArrayList;

public class SeatManage {
    private ArrayList<Seat> seats;

    public SeatManage(){
        this.seats = new ArrayList<Seat>();
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void addSeats(Seat newSeat){
        this.seats.add(newSeat);
    }
}
