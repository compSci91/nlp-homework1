import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberFinderTest {
    @Test
    public void shouldReturnPhoneNumberFromLabeledNumber(){
        List<String> expectedPhoneNumbers = new ArrayList<String>() {{ add("979-862-2908");  }};

        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber("Phone: (979) 862-2908");

        Assert.assertEquals(expectedPhoneNumbers, returnedPhoneNumbers);
    }

    @Test
    public void shouldReturnPHoneNumberWhenLabeledWithTelAndCountryCode() {
        List<String> expectedPhoneNumbers = new ArrayList<String>() {{ add("979-862-2908");  }};
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber("Tel (+1): 979-862-2908");

        Assert.assertEquals(expectedPhoneNumbers, returnedPhoneNumbers);
    }

    @Test
    public void shouldReturnPhoneNumberWhenEmbeddedHTML(){
        List<String> expectedPhoneNumbers = new ArrayList<String>() {{ add("979-862-2908");  }};
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber("<a href=\"contact.html\">TEL</a> +1&thinsp;979&thinsp;862&thinsp;2908");

        Assert.assertEquals(expectedPhoneNumbers, returnedPhoneNumbers);
    }
}