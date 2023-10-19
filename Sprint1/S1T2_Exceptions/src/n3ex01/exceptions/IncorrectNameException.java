package n3ex01.exceptions;

public class IncorrectNameException extends Exception{
    public IncorrectNameException(){
        super("Given person name is incorrect.\n");
    }
}
