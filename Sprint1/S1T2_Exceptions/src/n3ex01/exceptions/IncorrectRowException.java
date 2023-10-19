package n3ex01.exceptions;

public class IncorrectRowException extends Exception{
    public IncorrectRowException(){
        super("Given row number is incorrect.\n");
    }
}
