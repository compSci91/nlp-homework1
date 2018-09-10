import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFinder {
    public List<String> findEmail(String perspectiveEmail) {
        List<String> foundEmails = new ArrayList<String>();

        String nameRegEx = "[a-z]*";
        String atRegex =  "(\\(at\\)|\\sat\\s|@)";
        String dotRegex = "(\\.|\\sdot\\s)";

        String regularExpression = nameRegEx + atRegex + "cse" + dotRegex + "tamu" + dotRegex + "edu";
        //Pattern pattern = Pattern.compile(regularExpression);
        Pattern pattern = Pattern.compile("(?=(" + regularExpression + "))");
        Matcher matcher = pattern.matcher(perspectiveEmail);

        int fromIndex = 0;
        while (matcher.find(fromIndex)) {
           // for (int i = 0; i <= matcher.groupCount(); i++) {
            String matchedGroup = matcher.group(1);
                System.out.println(matchedGroup);
            int indexOfGroup = perspectiveEmail.indexOf(matchedGroup, fromIndex);
            fromIndex = indexOfGroup + matchedGroup.length();
//                System.out.println(i + " --> " + matcher.group(i));
//                System.out.println(matcher.group(i));
         //   }

            matchedGroup = matchedGroup.replaceAll("\\(at\\)", "@");
            matchedGroup = matchedGroup.replaceAll(" at ", "@");
            matchedGroup = matchedGroup.replaceAll(" dot ", ".");
            foundEmails.add(matchedGroup);

        }

        String anotherRegularExpression ="<script type=\"text/javascript\">obfuscate\\(’(cse.tamu.edu)’,’(huangrh)’\\)</script>";

        pattern = Pattern.compile(anotherRegularExpression);
        matcher = pattern.matcher(perspectiveEmail);

        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + " --> " + matcher.group(i));
                System.out.println(matcher.group(i));
            }

            foundEmails.add( matcher.group(2) + "@" + matcher.group(1));
        }




        return foundEmails;
    }
}
