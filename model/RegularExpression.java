package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static boolean test(String testString, String regularExpression) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(testString);
        return matcher.find();
    }
}
