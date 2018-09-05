import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFinder {
    public String findEmail(String perspectiveEmail) {

        /*
            1. Any number of letters
            2. @ or (at) or _at_
            3. Any number of letters
            4. .edu
         */
        String regularExpression ="[a-z]*(\\(at\\)|\\sat\\s|@)cse\\.tamu\\.edu";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(perspectiveEmail);

        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + " --> " + matcher.group(i));
                System.out.println(matcher.group(i));
            }

            perspectiveEmail = perspectiveEmail.replaceAll("\\(at\\)", "@");
            perspectiveEmail = perspectiveEmail.replaceAll(" at ", "@");
        }






        return perspectiveEmail;
    }
}
