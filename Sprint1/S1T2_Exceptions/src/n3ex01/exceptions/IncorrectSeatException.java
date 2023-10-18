package n3ex01.exceptions;

public class IncorrectSeatException extends Exception{
    public IncorrectSeatException(){
        super("Given seat number is incorrect.");
    }
}
