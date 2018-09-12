import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFinder {
    public List<String> findEmail(String perspectiveEmail) {
        List<String> foundEmails = new ArrayList<String>();

        String localPart = "[a-zA-Z]*";
        String atRegex =  "(\\(at\\)|\\sat\\s|\\s?@\\s?|\\sWHERE\\s|&#x40;)";
        String dotRegex = "(\\.|\\sdot\\s)";
        String optionalDotRegex = "(?:\\.|\\sdot\\s|\\sDOM\\s|;)?";
        String noCaptureDotRegex =  "(?:\\.|\\sdot\\s|\\sDOM\\s|;)";
        String domain = "[a-zA-Z]*" + optionalDotRegex + "[a-zA-Z]*" + noCaptureDotRegex + "(?:edu|EDU)";


        String regularExpression = localPart + atRegex + domain; //"cse" + dotRegex + "tamu" + dotRegex + "edu";
        Pattern pattern = Pattern.compile("(?=(" + regularExpression + "))");
        Matcher matcher = pattern.matcher(perspectiveEmail);

        int fromIndex = 0;
        while (matcher.find(fromIndex)) {
            String matchedGroup = matcher.group(1);
                System.out.println(matchedGroup);
            int indexOfGroup = perspectiveEmail.indexOf(matchedGroup, fromIndex);
            fromIndex = indexOfGroup + matchedGroup.length();


            matchedGroup = matchedGroup.replaceAll(atRegex, "@");
            matchedGroup = matchedGroup.replaceAll(" dot ", ".");
            matchedGroup = matchedGroup.replaceAll(noCaptureDotRegex, ".");
            foundEmails.add(matchedGroup);

        }




      //  String anotherRegularExpression = "<script type=\"text/javascript\">obfuscate\\(’(" + domain + ")’,’(" + localPart + ")’\\)</script>";
        String anotherRegularExpression = "obfuscate\\('(" + domain + ")','(" + localPart + ")'\\)";


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
