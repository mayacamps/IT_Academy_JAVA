package n1exercise2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		The static method can be accessed without needing 
		to create an object.
		*/
		System.out.println(Car.slowDown());
		
		/*
		However, the non-static method can only be accessed if 
		an object is created.
		*/
		Car car = new Car("Focus");
		System.out.println(car.accelerate());
		
		
		
		
		
	}

}
