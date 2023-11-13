package n2ex02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {

	static Scanner en = new Scanner(System.in);

	public static byte readByte(String message) {
		byte res = 0;
		boolean isByte = false;
		
		do {
			System.out.println(message);
			try {
				res = en.nextByte();
				isByte = true;
			} catch (InputMismatchException e) {
				System.err.println("Format error.");
				en.nextLine();
			}
		} while (!isByte);
		
		return res;
	}
	
	public static int readInt(String message) {
		int res = 0;
		boolean isInt = false;
		
		do {
			System.out.println(message);
			try {
				res = en.nextInt();
				isInt = true;
			} catch (InputMismatchException e) {
				System.err.println("Format error.");
				en.nextLine();
			}
		} while (!isInt);
		
		return res;
	}
	
	public static float readFloat(String message) {
		float res = 0f;
		boolean isFloat = false;
		
		do {
			System.out.println(message);
			try {
				res = en.nextFloat();
				if (res % 1 == 0) { // Make sure is not integer
					throw new InputMismatchException();
				}
				isFloat = true;
			} catch (InputMismatchException e) {
				System.err.println("Format error.");
				en.nextLine();
			}
		} while (!isFloat);
		
		return res;
	}
	
	public static double readDouble(String message) {
		double res = 0d;
		boolean isDouble = false;
		
		do {
			System.out.println(message);
			try {
				res = en.nextDouble();
				if (res % 1 == 0) { // Make sure is not integer
					throw new InputMismatchException();
				} else {
					isDouble = true;
				}
			} catch (InputMismatchException e) {
				System.err.println("Format error.");
				en.nextLine();
			}
		} while (!isDouble);
		
		return res;
	}
	
	public static char readChar(String message) {
		char res = ' ';
		String user = "";
		boolean isChar = false;
		
		do {
			System.out.println(message);
			try {
				user = en.nextLine();
				if (user.length() != 1) { // Only accept 1-length String
					throw new Exception();
				}
				res = user.charAt(0); // Convert String to char
				isChar = true;
				
			} catch (Exception e) {
				System.err.println("Format error.");
			}	
		} while (!isChar);
		
		return res;
	}
	
	public static String readString(String message) {
		String res = "";
		boolean isString = false;

		do {
			System.out.println(message);
			try {
				res = en.nextLine();
				if (!res.matches("^[a-zA-Z]+$") || ( res.length() < 2 )) { //Introduce only-letter String and not char
					throw new Exception();
				}
				isString = true;

			} catch (Exception e) {
				System.err.println("Format error.");
			}
			
		} while (!isString);

		return res;
	}

	public static boolean readYesNo(String message){
		boolean yesNo = false;
		String res = "";
		boolean result = false;

		do{
			System.out.println(message);
			try {
				res = en.nextLine();
				if (res.equalsIgnoreCase("y")){
					yesNo =  true;
					result = true;
				} else if (res.equalsIgnoreCase("n")){
					yesNo = true;
					result = false;
				} else {
                    throw new Exception();
                }
			} catch (Exception e){
				System.out.println("Format error. Please answer with y/n" + e.getMessage());
			}

		} while (!yesNo);

		return result;
	}
	
	
	
}
