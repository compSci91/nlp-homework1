import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberFinder {
    public String findPhoneNumber(String perspectivePhoneNumber) {
        String reconstructedPhoneNumber = "";


        String areaCodeRegEx = "\\(?([\\d]{3})\\)?";
        String phoneNumberRegEx = "([\\d]{3}-[\\d]{4})";
        String prefixRegEx = "(Phone|Tel \\(\\+[\\d]{1,3}\\))";

        String regularExpression = prefixRegEx + ":\\s"+ areaCodeRegEx + "[\\s|-]" + phoneNumberRegEx;

        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(perspectivePhoneNumber);

        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(i + " --> " + matcher.group(i));
                System.out.println(matcher.group(i));
            }

           reconstructedPhoneNumber =  matcher.group(2) + "-" + matcher.group(3);

            return reconstructedPhoneNumber;
        }




        return reconstructedPhoneNumber;
    }
}
