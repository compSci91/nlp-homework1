import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberFinder {
    public List<String> findPhoneNumber(String perspectivePhoneNumber) {

        List<String> phoneNumberToReturn = new ArrayList<String>();

        String reconstructedPhoneNumber = "";

        String countryCodeRegEx = "\\(?\\+[\\d]{1,3}\\)?";
        String areaCodeRegEx = "\\(?([\\d]{3})\\)?";
        String firstPartOfPhoneNumber = "[\\d]{3}";
        String secondPartOfPhoneNumber = "[\\d]{4}";
        String phoneNumberRegEx = "(" + firstPartOfPhoneNumber + "-" + secondPartOfPhoneNumber + ")";
        String prefixRegEx = "(Phone|Tel " + countryCodeRegEx + ")";

        String regularExpression = prefixRegEx + ":\\s"+ areaCodeRegEx + "[\\s|-]" + phoneNumberRegEx;

        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(perspectivePhoneNumber);

        int fromIndex = 0;
        while (matcher.find(fromIndex)) {
//            for (int i = 0; i <= matcher.groupCount(); i++) {
//                System.out.println(i + " --> " + matcher.group(i));
//                System.out.println(matcher.group(i));
//            }

            String matchedGroup = matcher.group(1);
            int indexOfGroup = perspectivePhoneNumber.indexOf(matchedGroup, fromIndex);
            fromIndex = indexOfGroup + matchedGroup.length();

           reconstructedPhoneNumber =  matcher.group(2) + "-" + matcher.group(3);
            phoneNumberToReturn.add(reconstructedPhoneNumber);
        }

        String anotherRegularExpression = "<a href=\"contact.html\">TEL</a> " + countryCodeRegEx + "&thinsp;(" + areaCodeRegEx + ")&thinsp;(" + firstPartOfPhoneNumber + ")&thinsp;(" + secondPartOfPhoneNumber + ")";


        pattern = Pattern.compile(anotherRegularExpression);
        matcher = pattern.matcher(perspectivePhoneNumber);

        fromIndex = 0;

        while (matcher.find(fromIndex)) {
//            for (int i = 0; i <= matcher.groupCount(); i++) {
//                System.out.println(i + " --> " + matcher.group(i));
//                System.out.println(matcher.group(i));
//            }

            String matchedGroup = matcher.group(1);
            int indexOfGroup = perspectivePhoneNumber.indexOf(matchedGroup, fromIndex);
            fromIndex = indexOfGroup + matchedGroup.length();

            reconstructedPhoneNumber =  matcher.group(2) + "-" + matcher.group(3) + "-" + matcher.group(4);

            phoneNumberToReturn.add(reconstructedPhoneNumber);
        }


        //phoneNumberToReturn.add( reconstructedPhoneNumber );

        return phoneNumberToReturn;
    }
}
