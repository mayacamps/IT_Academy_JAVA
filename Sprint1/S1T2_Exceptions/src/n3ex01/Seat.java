package n3ex01;

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

    public boolean equals(Seat otherSeat){
        return this.getRowNum() == otherSeat.getRowNum() &&
                this.getSeatNum() == otherSeat.getSeatNum();
    }

    public String toString(){
        return "Row: " + this.getRowNum() +
                ", Seat: " + this.getSeatNum() +
                ", Person: " + this.getNameReserv();
    }
}
