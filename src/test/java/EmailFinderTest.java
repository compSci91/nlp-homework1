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

    @Test
    public void shouldReturnEmailsFromAStringWhichContainsMoreThanJustEmails(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("huangrh@cse.tamu.edu");  add("howjosh@cse.tamu.edu"); }};

        List<String> returnedEmails = emailFinder.findEmail("huangrh at cse dot tamu dot edu \n howjosh(at)cse.tamu.edu extra stuff at the end ldjfsl ;f");
        Assert.assertEquals(expectedEmails, returnedEmails);

    }

    @Test
    public void shouldReturnEmailsFromAStringWhichContainsAllTypesOfEmails(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("huangrh@cse.tamu.edu");   add("howjosh@cse.tamu.edu"); add("osa@cse.tamu.edu");}};

        List<String> returnedEmails = emailFinder.findEmail("huangrh at cse dot tamu dot edu \n <script type=\"text/javascript\">obfuscate(’cse.tamu.edu’,’osa’)</script> ldjskflsfdj howjosh(at)cse.tamu.edu extra stuff at the end ldjfsl ;f");
        Assert.assertEquals(expectedEmails, returnedEmails);
    }

    @Test
    public void shouldReturnEmailsWhenThereIsASpaceBetweenTheLocalPartAndTheDomain(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("ashishg@stanford.edu");}};

        List<String> returnedEmails = emailFinder.findEmail("    Email: ashishg @ stanford.edu<o:p></o:p><br>\n");
        Assert.assertEquals(expectedEmails, returnedEmails);
    }


    @Test
    public void shouldReturnEmailsWhenInterspersedWithDashes(){
        EmailFinder emailFinder = new EmailFinder();
        List<String> expectedEmails = new ArrayList<String>() {{ add("dlwh@stanford.edu");}};

        List<String> returnedEmails = emailFinder.findEmail("d-l-w-h-@-s-t-a-n-f-o-r-d-.-e-d-u\n");
        Assert.assertEquals(expectedEmails, returnedEmails);
    }




}