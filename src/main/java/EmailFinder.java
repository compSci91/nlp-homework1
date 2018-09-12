import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFinder {
    public List<String> findEmail(String perspectiveEmail) {
        List<String> foundEmails = new ArrayList<String>();

        String localPart = "[a-z]*";
        String atRegex =  "(\\(at\\)|\\sat\\s|@)";
        String dotRegex = "(\\.|\\sdot\\s)";

        String regularExpression = localPart + atRegex + "cse" + dotRegex + "tamu" + dotRegex + "edu";
        Pattern pattern = Pattern.compile("(?=(" + regularExpression + "))");
        Matcher matcher = pattern.matcher(perspectiveEmail);

        int fromIndex = 0;
        while (matcher.find(fromIndex)) {
            String matchedGroup = matcher.group(1);
                System.out.println(matchedGroup);
            int indexOfGroup = perspectiveEmail.indexOf(matchedGroup, fromIndex);
            fromIndex = indexOfGroup + matchedGroup.length();


            matchedGroup = matchedGroup.replaceAll("\\(at\\)", "@");
            matchedGroup = matchedGroup.replaceAll(" at ", "@");
            matchedGroup = matchedGroup.replaceAll(" dot ", ".");
            foundEmails.add(matchedGroup);

        }


        String anotherDotRegex = "(?:\\.|\\sdot\\s)";


        String domain = localPart + anotherDotRegex + "tamu.edu";
        String anotherRegularExpression = "<script type=\"text/javascript\">obfuscate\\(’(" + domain + ")’,’(" + localPart + ")’\\)</script>";

        pattern = Pattern.compile(anotherRegularExpression);
        matcher = pattern.matcher(perspectiveEmail);

        fromIndex = 0;
        while (matcher.find(fromIndex)) {

            String matchedGroup = matcher.group(1);
            System.out.println(matchedGroup);
            int indexOfGroup = perspectiveEmail.indexOf(matchedGroup, fromIndex);
            fromIndex = indexOfGroup + matchedGroup.length();

//            for (int i = 0; i <= matcher.groupCount(); i++) {
//                System.out.println(i + " --> " + matcher.group(i));
//                System.out.println(matcher.group(i));
//            }

            foundEmails.add( matcher.group(2) + "@" + matcher.group(1));
        }




        return foundEmails;
    }
}
