import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ContactInformationTest {

    @Test
    public void shouldDisplayContactInformation(){
        String expectedString = "ashishg e ashishg@stanford.edu";

        String filename = "ashishg";
        String type = "e";
        String value = "ashishg@stanford.edu";

        ContactInformation contactInformation = new ContactInformation(filename, type, value);

        String returnedString = contactInformation.toString();

        assertEquals(expectedString, returnedString);
    }
}