package ID9309;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneTest {
    private static ValidatePhone validatePhone;
    public static final String[] validPhone = new String[]{"(84)-(0978489648)"};
    public static final String[] invalidPhone = new String[]{"(a8)-(22222222)", "(84)-(22b22222)", "(84)-(9978489648)"};

    public static void main(String[] args) {
        validatePhone = new ValidatePhone();
        for (String phone : validPhone) {
            boolean isValid = validatePhone.validate(phone);
            System.out.println(phone + " " + isValid);
        }
        for (String phone : invalidPhone) {
            boolean isValid = validatePhone.validate(phone);
            System.out.println(phone + " " + isValid);
        }
    }
}

class ValidatePhone {
    private static final String PHONE_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public ValidatePhone() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
