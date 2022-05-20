package exceptions;

public class IllegalCarNameException extends IllegalArgumentException{
    
    public IllegalCarNameException(String s) {
        super(s);
    }
}
