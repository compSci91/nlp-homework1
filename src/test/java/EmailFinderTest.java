import org.junit.Assert;
import org.junit.Test;

public class EmailFinderTest {

    @Test
    public void shouldEmailWhenAlreadyFormattedProperly(){
        EmailFinder emailFinder = new EmailFinder();
        String expectedEmail = "huangrh@cse.tamu.edu";

        String returnedEmail = emailFinder.findEmail("huangrh@cse.tamu.edu");


        Assert.assertEquals(expectedEmail, returnedEmail);
    }
}