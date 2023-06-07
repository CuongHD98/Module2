package Manage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private Pattern pattern;
    private Matcher matcher;
    public static final String UserName_PATTERN = "^[A-Z][a-z]+\\d+$";//Cuong98
    public static final String PassWord_PATTERN = "^([A-Z][A-Za-z0-9]+){6,10}$";//Cuong98
    public static final String ROLE_PATTERN = "^(-1|0|1)$";
    public static final String Name_PATTERN = "^[A-Z][a-z]+$";//Cuong
    public static final String Gender_PATTERN = "^(Male|Female)$";
    public static final String Birthday_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/\\d{4}$";//(dd/MM/yyyy)
    public static final String Phone_PATTERN = "^0[1-9]\\d{8}$";//0986640945
    public static final String Email_PATTERN = "^[a-z]\\w+@[a-z]+\\.[a-z]+$";//hodiencuongqm12@gmail.com
    public static final String Quantity_PATTERN = "^\\d+$";//15
    public static final String NameMedicine_PATTERN = "^[A-Z][a-z]+$";//Cefalexin
    public static final String TypeMedicine_PATTERN = "^(Water|Gel|Pill)$";
    public static final String EffectMedicine_PATTERN = "^[A-Za-z0-9\\s]{10,1000}&";//Chong mat buon non da co Panadol
    public static final String TimesUseMedicine_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/\\d{4}-(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/\\d{4}$";//12/5/2000-20/8/2001
    public static final String Price_PATTERN = "^[1-9]\\d*\\.\\d+$"; //12.5

    public Validate() {
    }

    public boolean isValidateInputString(String inputString, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(inputString);
        return matcher.matches();
    }
}
