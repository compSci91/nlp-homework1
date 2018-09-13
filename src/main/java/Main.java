import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<ContactInformation> contactInformation = new ArrayList<ContactInformation>();
        EmailFinder emailFinder = new EmailFinder();
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        File folder = new File("/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/Homework 1/PA1-638/data_dev/dev/");
        File[] listOfFiles = folder.listFiles();

        for(int i = 0; i< listOfFiles.length; i++){
            File file = listOfFiles[i];
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                List<String> returnedEmails = emailFinder.findEmail(nextLine);
                List<String> returnedPhoneNumbers = phoneNumberFinder.findPhoneNumber(nextLine);

//                for(String returnedEmail : returnedEmails ){
//                    contactInformation.add(new ContactInformation(file.getName(), "e", returnedEmail));
//                }

                for(String returnedPhoneNumber : returnedPhoneNumbers) {
                    contactInformation.add(new ContactInformation(file.getName(), "p", returnedPhoneNumber));
                }
            }

        }

        for(ContactInformation email : contactInformation ){
            System.out.println(email);
        }
    }
}
