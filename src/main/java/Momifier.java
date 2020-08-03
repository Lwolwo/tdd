import jdk.nashorn.internal.runtime.regexp.joni.*;

import java.util.regex.*;
import java.util.regex.Matcher;

public class Momifier {

    public String convert(String str) throws StringNullException {
        if (str.length() == 0) {
            throw new StringNullException();
        } else if (!isVowelsLengthMoreThan30Percent(str)) {
            return str;
        } else {
            Pattern pattern = Pattern.compile("([aeiouAEIOU]{2,})");
            Matcher matcher = pattern.matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String group = matcher.group(1);
                String replaceStr = group.replaceAll("([aeiouAEIOU])", "$1mommy");
                matcher.appendReplacement(stringBuffer, replaceStr);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
    }

    public boolean isVowelsLengthMoreThan30Percent(String str) {
        String lowerCaseStr = str.toLowerCase();
        int vowelsLength = 0;
        for (int i = 0; i < lowerCaseStr.length(); i++) {
            char word = lowerCaseStr.charAt(i);
            if (word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u') {
                vowelsLength++;
            }
        }
        return vowelsLength > str.length() * 0.3;
    }
}
