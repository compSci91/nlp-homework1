import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class PhoneNumberFinderTest {
    @Test
    public void shouldReturnPhoneNumberFromLabeledNumber(){
        String expectedPhoneNumber = "979-862-2908";
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        String returnedPhoneNumber = phoneNumberFinder.findPhoneNumber("Phone: (979) 862-2908");

        Assert.assertEquals(expectedPhoneNumber, returnedPhoneNumber);
    }

    @Test
    public void shouldReturnPHoneNumberWhenLabeledWithTelAndCountryCode() {
        String expectedPhoneNumber = "979-862-2908";
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        String returnedPhoneNumber = phoneNumberFinder.findPhoneNumber("Tel (+1): 979-862-2908");

        Assert.assertEquals(expectedPhoneNumber, returnedPhoneNumber);
    }

    @Test
    public void shouldReturnPhoneNumberWhenEmbeddedHTML(){
        String expectedPhoneNumber = "979-862-2908";
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        String returnedPhoneNumber = phoneNumberFinder.findPhoneNumber("<a href=\"contact.html\">TEL</a> +1&thinsp;979&thinsp;862&thinsp;2908");

        Assert.assertEquals(expectedPhoneNumber, returnedPhoneNumber);
    }
}