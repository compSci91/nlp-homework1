import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //TODO: dlhw isn't handled yet because it's stupid!
        List<ContactInformation> emails = new ArrayList<ContactInformation>();
        EmailFinder emailFinder = new EmailFinder();

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
                List<String> returnedEmails = emailFinder.findEmail(sc.nextLine());
                for(String returnedEmail : returnedEmails ){
                    emails.add(new ContactInformation(file.getName(), "e", returnedEmail));
                }
            }

        }

        for(ContactInformation email : emails ){
            System.out.println(email);
        }
    }
}
