import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTeleNumber {
    private static final String TELE_NUMBER_REGEX = "^[(][8][4][)][-][(][0]\\d{9}[)]$";

    public ValidateTeleNumber() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(TELE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
