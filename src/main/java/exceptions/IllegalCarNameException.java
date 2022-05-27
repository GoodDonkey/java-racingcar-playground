package exceptions;

public class IllegalCarNameException extends IllegalArgumentException{
    
    public static String message = "부적절한 자동차 이름이 포함되어 있습니다.";
    
    public IllegalCarNameException(String s) {
        super(s);
        message = s;
    }
    
    public IllegalCarNameException() {
    }
}
