import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberFinder {
    public String findPhoneNumber(String perspectivePhoneNumber) {
        String reconstructedPhoneNumber = "";


        String regularExpression = "Phone: \\((979)\\) (862-2908)";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(perspectivePhoneNumber);

        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + " --> " + matcher.group(i));
                System.out.println(matcher.group(i));
            }

           reconstructedPhoneNumber =  matcher.group(1) + "-" + matcher.group(2);
        }




        return reconstructedPhoneNumber;
    }
}
