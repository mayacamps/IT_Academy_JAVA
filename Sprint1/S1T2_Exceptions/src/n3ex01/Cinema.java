package n3ex01;

import n2ex01.Entry;
import n3ex01.exceptions.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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
                case 1 -> showSeats();
                case 2 -> showSeatsPerson();
                case 3 -> reserveSeat();
                case 4 -> cancelReservation();
                case 5 -> cancelReservationsPerson();
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Please select a valid option.");
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
        if (existsAnyReserv()) {
            System.out.println("Reserved seats:");
            for (Seat s : seatManage.getSeats()) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public void showSeatsPerson(){
        Scanner sc = new Scanner(System.in);
        int seatsToName = 0;
        StringBuilder listSeats = new StringBuilder();

        if (existsAnyReserv()){
            System.out.println("Introduce the person's name");
            String name = sc.nextLine();

            for (Seat s: seatManage.getSeats()){
                if (s.getNameReserv().equalsIgnoreCase(name)){
                    listSeats.append(s).append("\n");
                    seatsToName++;
                }
            }
            if (seatsToName == 0){
                System.out.println("There is no seat reserved under this name.\n");
            } else {
                System.out.println("Seats reserved under " + name + ": \n" +
                        listSeats);
            }
        }
    }

    public void reserveSeat() {
        try {
            int numRow = introduceRow();
            int numSeat = introduceSeat();
            String name = introducePerson();
            Seat newSeat = new Seat(numRow, numSeat, name);
            seatManage.addSeat(newSeat);
        } catch (IncorrectNameException | IncorrectRowException | IncorrectSeatException e){
            System.err.println(e.getMessage());
        }
    }

    public void cancelReservation(){
        if (existsAnyReserv()){
            try {
                int numRow = introduceRow();
                int numSeat = introduceSeat();
                seatManage.deleteSeat(numRow, numSeat);
                System.out.println("Deleted reservation!\n");
            }catch (IncorrectRowException | IncorrectSeatException | FreeSeatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void cancelReservationsPerson(){
        if (existsAnyReserv()) {
            try {
                String name = introducePerson();
                ArrayList<Seat> seatsToDelete = new ArrayList<>();

                for (Seat s : seatManage.getSeats()){
                    if (s.getNameReserv().equalsIgnoreCase(name)){
                        seatsToDelete.add(s);
                    }
                }
                
                if (!seatsToDelete.isEmpty()){
                    seatManage.getSeats().removeAll(seatsToDelete);
                    System.out.println("Deleted all reservations under " + name + "\n");
                } else {
                    System.out.println("There are no seats reserved under " + name + "\n");
                }

            } catch (IncorrectNameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String introducePerson() throws IncorrectNameException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce the person's name");
        String name = sc.nextLine();
        for (int i = 0; i < name.length(); i++){
            if (Character.isDigit(name.charAt(i))){
                throw new IncorrectNameException();
            }
        }
        return name;
    }
    public int introduceRow() throws IncorrectRowException {
        int rowNum = Entry.readInt("Introduce the row number");

        if (rowNum >= 1 && rowNum <= this.numRows){
            return rowNum;
        }
        throw new IncorrectRowException();
    }

    public int introduceSeat() throws IncorrectSeatException {
        int seatNum = Entry.readInt("Introduce the seat number");
        if (seatNum >= 1 && seatNum <= this.numSeatsRow){
            return seatNum;
        }
        throw new IncorrectSeatException();
    }

    public void getInitialData(){
        System.out.println("Initializing cinema...");
        this.numRows = Entry.readInt("How many rows are there?");
        this.numSeatsRow = Entry.readInt("Hoy many seats are in a row?");
    }

    public boolean existsAnyReserv(){
        if (!seatManage.getSeats().isEmpty()){
            return true;
        }
        System.out.println("There are no seats reserved yet.\n");
        return false;
    }
}
