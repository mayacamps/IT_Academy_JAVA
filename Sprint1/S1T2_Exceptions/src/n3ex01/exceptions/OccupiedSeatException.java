package n3ex01.exceptions;

public class OccupiedSeatException extends Exception{
    public OccupiedSeatException(){
        super("Seat occupied. Cannot make reservation.");
    }
}
