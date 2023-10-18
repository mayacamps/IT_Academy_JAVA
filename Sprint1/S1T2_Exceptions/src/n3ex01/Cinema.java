package n3ex01;

import n2ex01.Entry;

import java.util.Scanner;

public class Cinema {
    private int numRows, numSeatsRow;
    private SeatManage seatManage;

    public Cinema() {
        this.seatManage = new SeatManage();
        getInitialData();
    }

    public void init() {
        int opt;
        do {
            opt = menu();
            switch (opt) {
                case 1:
                    showSeats();
                    break;
                case 2:
                    showSeatsPerson();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    break;
            }
        } while (opt != 0);
    }

    public int menu(){
        return Entry.readInt("Cinema menu. Choose one option.\n"
                + "1. Show all reserved seats.\n"
                + "2. Show reserved seats for one person.\n"
                + "3. Reserve seat.\n"
                + "4. Cancel seat reservation.\n"
                + "5. Cancel all reservations for one person.\n"
                + "0. Exit.");
    }

    public void showSeats() {
        if (!seatManage.getSeats().isEmpty()){
            System.out.println("Reserved seats:");
            for (Seat s : seatManage.getSeats()){
                System.out.println(s);
            }
        } else {
            System.out.println("There are no seats reserved yet.\n");
        }
    }

    public void showSeatsPerson(){
        int seatsToName = 0;
        String name = Entry.readString("Introduce the person's name");
        if (!seatManage.getSeats().isEmpty()){
            for (Seat s: seatManage.getSeats()){
                if (s.getNameReserv().equalsIgnoreCase(name)){
                    System.out.println(s);
                    seatsToName++;
                }
            }
            if (seatsToName == 0){
                System.out.println("There is no seat reserved under this name.\n");
            }
        } else {
            System.out.println("There are no seats reserved yet.\n");
        }
    }
    public void getInitialData(){
        this.numRows = Entry.readInt("How many rows are there?");
        this.numSeatsRow = Entry.readInt("Hoy many seats are in a row?");
    }
}
