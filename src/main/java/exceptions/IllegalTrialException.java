package exceptions;

public class IllegalTrialException extends IllegalArgumentException{
    
    public static String message = "횟수가 부적절합니다.";
    
    public IllegalTrialException() {
    }
    
    public IllegalTrialException(String s) {
        super(s);
        message = s;
    }
}
