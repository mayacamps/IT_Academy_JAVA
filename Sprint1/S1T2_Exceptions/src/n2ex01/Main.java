package n2ex01;

public class Main {

	public static void main(String[] args) {
		System.out.println(Entry.readByte("Introduce a byte: "));
		System.out.println(Entry.readInt("Introduce an integer: "));
		System.out.println(Entry.readFloat("Introduce a float: "));
		System.out.println(Entry.readDouble("Introduce a double: "));
		System.out.println(Entry.readChar("Introduce a character: "));
		System.out.println(Entry.readString("Introduce a String (only letters): "));
		System.out.println(Entry.readYesNo("Are you a student? (y/n)"));
	
	}

}
