package n3ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner en = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numRows, numSeats, menuOpt;
	
		System.out.println("How many rows does the cinema room have?");
		numRows = getInt();
		
		System.out.println("How many seats does the cinema room have?");
		numSeats = getInt();
		
		do {
			System.out.println("Cinema menu:\n"
					+ "1. Show all reserved seats.\n"
					+ "2. Show reserved seats for one person.\n"
					+ "3. Reserve seat.\n"
					+ "4. Cancel seat reservation.\n"
					+ "5. Cancel all reservations for one person.\n"
					+ "0. Exit.\n ");
			
			menuOpt = getInt();
			
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
	
	public static int getInt() {
		int num = 0;
		boolean isInt = false;
		
		do {
			try {
				num = en.nextInt();
				isInt = true;
			} catch (InputMismatchException e){
				System.err.println("InputMismatchException: Please introduce a valid number.");
			}
			en.nextLine();
		} while (!isInt);
	
		return num;
	}
}

