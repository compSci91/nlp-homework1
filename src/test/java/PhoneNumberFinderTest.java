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
}