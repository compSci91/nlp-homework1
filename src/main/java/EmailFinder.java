import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFinder {
    public String findEmail(String perspectiveEmail) {

        String nameRegEx = "[a-z]*";
        String atRegex =  "(\\(at\\)|\\sat\\s|@)";
        String dotRegex = "(\\.|\\sdot\\s)";

        String regularExpression = nameRegEx + atRegex + "cse" + dotRegex + "tamu" + dotRegex + "edu";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(perspectiveEmail);

        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + " --> " + matcher.group(i));
                System.out.println(matcher.group(i));
            }

            perspectiveEmail = perspectiveEmail.replaceAll("\\(at\\)", "@");
            perspectiveEmail = perspectiveEmail.replaceAll(" at ", "@");
            perspectiveEmail = perspectiveEmail.replaceAll(" dot ", ".");
        }

        String anotherRegularExpression ="<script type=\"text/javascript\">obfuscate\\(’(cse.tamu.edu)’,’(huangrh)’\\)</script>";

        pattern = Pattern.compile(anotherRegularExpression);
        matcher = pattern.matcher(perspectiveEmail);

        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + " --> " + matcher.group(i));
                System.out.println(matcher.group(i));
            }
        }




        return perspectiveEmail;
    }
}
