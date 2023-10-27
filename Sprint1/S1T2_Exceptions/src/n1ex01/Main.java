package n1ex01;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Sale s = new Sale();
		try {
			s.calcTotal();
		} catch (EmptySaleException e) {
			System.err.println(e.getMessage());
		}

		List<String> words = Arrays.asList("hola", "caracola");
		try{
			for (int i = 1; i < words.size(); i++){
				System.out.println(words.get(i+1));
			}
		} catch (ArrayIndexOutOfBoundsException e){
			System.err.println(e.getMessage());
		}
		
	}

}
