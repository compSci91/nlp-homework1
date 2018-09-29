import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main { //8783449c-99ef-4b60-92bd-576723410e21
    public static void main(String[] args) {
        EmailFinder emailFinder = new EmailFinder();
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        //"/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/Homework 1/PA1-638/data_dev/dev/"
        String directory = args[0];
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        for(int i = 0; i< listOfFiles.length; i++){
            File file = listOfFiles[i];
            System.out.println(file.getName());
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

                for(String returnedEmail : returnedEmails ){
                    System.out.println(new ContactInformation(file.getName(), "e", returnedEmail));
                }

                for(String returnedPhoneNumber : returnedPhoneNumbers) {
                    System.out.println(new ContactInformation(file.getName(), "p", returnedPhoneNumber));
                }
            }

            System.out.println();
        }
    }
}
