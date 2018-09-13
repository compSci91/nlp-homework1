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
    public void shouldReturnPhoneNumberFromLabeledNumberWithNoSpaceBetweenAreaCodeAndPhoneNumber(){
        List<String> expectedPhoneNumbers = new ArrayList<String>() {{ add("979-862-2908");  }};

        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber("Phone: (979)862-2908");

        Assert.assertEquals(expectedPhoneNumbers, returnedPhoneNumbers);
    }

    @Test
    public void shouldReturnFaxNumberFromLabeledNumberWithNoSpaceBetweenAreaCodeAndPhoneNumber(){
        List<String> expectedPhoneNumbers = new ArrayList<String>() {{ add("979-862-2908");  }};

        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber("Fax: (979)862-2908");

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
    public void shouldReturnPhoneNumberWhenUnLabeled() {
        List<String> expectedPhoneNumbers = new ArrayList<String>() {{ add("650-723-4173");  }};
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber("      Admin asst: Roz Morf, Terman 405, (650)723-4173, rozm @ stanford.edu</span></p>\n");

        Assert.assertEquals(expectedPhoneNumbers, returnedPhoneNumbers);
    }

    @Test
    public void shouldReturnPhoneNumberWhenEmbeddedHTML(){
        List<String> expectedPhoneNumbers = new ArrayList<String>() {{ add("979-862-2908");  }};
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber("<a href=\"contact.html\">TEL</a> +1&thinsp;979&thinsp;862&thinsp;2908");

        Assert.assertEquals(expectedPhoneNumbers, returnedPhoneNumbers);
    }

    @Test
    public void shouldReturnAllPhoneNumbers(){
        List<String> expectedPhoneNumbers = new ArrayList<String>() {{ add("123-456-7890"); add("210-867-5309"); add("979-862-2908");}};
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber("<a href=\"contact.html\">TEL</a> +1&thinsp;979&thinsp;862&thinsp;2908 lskdfjlsfd Tel (+1): 123-456-7890 lsdjflsdf Phone: (210) 867-5309 ");

        Assert.assertEquals(expectedPhoneNumbers, returnedPhoneNumbers);
    }
}