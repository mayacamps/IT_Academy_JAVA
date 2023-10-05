package n1exercise1;

public class Main {

	// Main Class Loading - Static block
	static 
	{
		System.out.println("Main Static Block");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// StringIns Class Loading - First Class instance
		StringIns violin = new StringIns("Violin", 123);
		System.out.println(violin.play());
	
	}

}


