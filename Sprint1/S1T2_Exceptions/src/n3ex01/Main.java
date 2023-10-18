package n3ex01;

import n2ex01.Entry;
import java.util.Scanner;

public class Main {
	static Scanner en = new Scanner(System.in);

	public static void main(String[] args) {

		int numRows, numSeats, menuOpt;

		numRows = Entry.readInt("How many rows does the cinema room have?");
		numSeats  = Entry.readInt("How many seats does the cinema room have?");
		
		do {
			menuOpt = Entry.readInt("Cinema menu:\n"
					+ "1. Show all reserved seats.\n"
					+ "2. Show reserved seats for one person.\n"
					+ "3. Reserve seat.\n"
					+ "4. Cancel seat reservation.\n"
					+ "5. Cancel all reservations for one person.\n"
					+ "0. Exit.\n ");

			switch(menuOpt) {
			case 1:
				break;
			case 2:
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
		} while (menuOpt != 0);
		
	}

}

