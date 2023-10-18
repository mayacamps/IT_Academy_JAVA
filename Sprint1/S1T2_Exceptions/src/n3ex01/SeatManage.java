package n3ex01;

import n3ex01.exceptions.FreeSeatException;
import n3ex01.exceptions.OccupiedSeatException;

import java.util.ArrayList;

public class SeatManage {
    private ArrayList<Seat> seats;

    public SeatManage(){
        this.seats = new ArrayList<Seat>();
    }

    public ArrayList<Seat> getSeats() {
        return this.seats;
    }

    public void addSeat(Seat newSeat) throws OccupiedSeatException {
        for (Seat s: seats){
            if (!s.equals(newSeat)){
                seats.add(newSeat);
            }
            else throw new OccupiedSeatException();
        }
    }

    public int findSeat(int numRow, int numSeat) {
        for (Seat s: seats){
            if (s.getSeatNum() == numSeat && s.getRowNum() == numRow){
                return seats.indexOf(s);
            }
        }
        return -1;
    }

    public void deleteSeat(int numRow, int numSeat) throws FreeSeatException {
        if (!seats.isEmpty()){
            int pos = findSeat(numRow, numSeat);
            if (pos != -1){
                seats.remove(pos);
            } else throw new FreeSeatException();
        } else System.out.println("There are no reserved seats yet.\n");

    }
}
