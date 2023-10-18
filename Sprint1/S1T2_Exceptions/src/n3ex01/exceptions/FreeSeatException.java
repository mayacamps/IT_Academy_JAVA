package n3ex01.exceptions;

public class FreeSeatException extends Exception{
    public FreeSeatException(){
        super("The seat is not reserved.");
    }

}
