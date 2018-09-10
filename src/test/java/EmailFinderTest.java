import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmailFinderTest {

    @Test
    public void shouldReturnEmailsWhenAlreadyFormattedProperly(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("huangrh@cse.tamu.edu");  }};

        List<String> returnedEmails = emailFinder.findEmail("huangrh@cse.tamu.edu");

        Assert.assertEquals(expectedEmails, returnedEmails);
    }

    @Test
    public void shouldReturnEmailsWhenTheWordAtIsUsedInsteadofAnAtMark(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("huangrh@cse.tamu.edu");  }};

        List<String>returnedEmails = emailFinder.findEmail("huangrh(at)cse.tamu.edu");

        Assert.assertEquals(expectedEmails, returnedEmails);
    }

    @Test
    public void shouldReturnEmaislWhenTheWordAtIsUsedWithoutParenthesesInsteadOfAnAtMark(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("huangrh@cse.tamu.edu");  }};

        List<String> returnedEmail = emailFinder.findEmail("huangrh at cse.tamu.edu");

        Assert.assertEquals(expectedEmails, returnedEmail);
    }

    @Test
    public void shouldReturnEmailsWhenAllSymbolsHaveBeenTurnedIntoWords(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("huangrh@cse.tamu.edu");  }};

        List<String> returnedEmails = emailFinder.findEmail("huangrh at cse dot tamu dot edu");

        Assert.assertEquals(expectedEmails, returnedEmails);
    }

    @Test
    public void shouldReturnEmailsWhenThereIsAJavaScriptObfuscation(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("huangrh@cse.tamu.edu");  }};

        List<String> returnedEmails = emailFinder.findEmail("<script type=\"text/javascript\">obfuscate(’cse.tamu.edu’,’huangrh’)</script>");

        Assert.assertEquals(expectedEmails, returnedEmails);
    }

    @Test
    public void shouldReturnAllEmailsFromAString() {
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("huangrh@cse.tamu.edu");  add("howjosh@cse.tamu.edu"); }};

        List<String> returnedEmails = emailFinder.findEmail("huangrh at cse dot tamu dot edu  howjosh(at)cse.tamu.edu ");

        Assert.assertEquals(expectedEmails, returnedEmails);
    }
}