import org.junit.Assert;
import org.junit.Test;

public class EmailFinderTest {

    @Test
    public void shouldReturnEmailWhenAlreadyFormattedProperly(){
        EmailFinder emailFinder = new EmailFinder();
        String expectedEmail = "huangrh@cse.tamu.edu";

        String returnedEmail = emailFinder.findEmail("huangrh@cse.tamu.edu");

        Assert.assertEquals(expectedEmail, returnedEmail);
    }

    @Test
    public void shouldReturnEmailWhenTheWordAtIsUsedInsteadofAnAtMark(){
        EmailFinder emailFinder = new EmailFinder();
        String expectedEmail = "huangrh@cse.tamu.edu";

        String returnedEmail = emailFinder.findEmail("huangrh(at)cse.tamu.edu");

        Assert.assertEquals(expectedEmail, returnedEmail);
    }

    @Test
    public void shouldReturnEmailWhenTheWordAtIsUsedWithoutParenthesesInsteadOfAnAtMark(){
        EmailFinder emailFinder = new EmailFinder();
        String expectedEmail = "huangrh@cse.tamu.edu";

        String returnedEmail = emailFinder.findEmail("huangrh at cse.tamu.edu");

        Assert.assertEquals(expectedEmail, returnedEmail);
    }

    @Test
    public void shouldReturnEmailWhenAllSymbolsHaveBeenTurnedIntoWords(){
        EmailFinder emailFinder = new EmailFinder();
        String expectedEmail = "huangrh@cse.tamu.edu";

        String returnedEmail = emailFinder.findEmail("huangrh at cse dot tamu dot edu");

        Assert.assertEquals(expectedEmail, returnedEmail);
    }

    @Test
    public void shouldReturnEmailWhenThereIsAJavaScriptObfuscation(){
        EmailFinder emailFinder = new EmailFinder();
        String expectedEmail = "huangrh@cse.tamu.edu";

        String returnedEmail = emailFinder.findEmail("<script type=\"text/javascript\">obfuscate(’cse.tamu.edu’,’huangrh’)</script>");

        Assert.assertEquals(expectedEmail, returnedEmail);
    }
}