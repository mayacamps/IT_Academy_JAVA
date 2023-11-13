package n3ex01;

import java.util.Objects;

public class Seat {
    private int rowNum, seatNum;
    private String nameReserv;

    public Seat(int rowNum, int seatNum, String nameReserv) {
        this.rowNum = rowNum;
        this.seatNum = seatNum;
        this.nameReserv = nameReserv;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String getNameReserv() {
        return nameReserv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return rowNum == seat.rowNum && seatNum == seat.seatNum && Objects.equals(nameReserv, seat.nameReserv);
    }

    @Override
    public String toString(){
        return "Row: " + this.getRowNum() +
                ", Seat: " + this.getSeatNum() +
                ", Person: " + this.getNameReserv();
    }
}
