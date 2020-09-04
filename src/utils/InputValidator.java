package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
// Singleton pattern 참고 : https://gocoder.tistory.com/1857
    private static InputValidator instance;

    private InputValidator(){

    }

    public static InputValidator getInstance(){
        if(instance == null){
            instance = new InputValidator();
        }
        return instance;
    }

    private final String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    //https://blog.mailtrap.io/java-email-validation/

    private final String phoneRegex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    //https://java2blog.com/validate-phone-number-java/

    public boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
