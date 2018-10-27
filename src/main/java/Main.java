import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main { //8783449c-99ef-4b60-92bd-576723410e21
    public static void main(String[] args) {
        EmailFinder emailFinder = new EmailFinder();
        PhoneNumberFinder phoneNumberFinder = new PhoneNumberFinder();

        //String directory = args[0];
        String directory = "/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/Homework 1/build/classes/main/data_dev/dev/";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        Set<ContactInformation> foundContactInformation = new HashSet<ContactInformation>();

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
                    ContactInformation email = new ContactInformation(file.getName(), "e", returnedEmail);
                    foundContactInformation.add(email);
                  //  System.out.println(email);
                }

                for(String returnedPhoneNumber : returnedPhoneNumbers) {
                    ContactInformation phoneNumber = new ContactInformation(file.getName(), "p", returnedPhoneNumber);
                    foundContactInformation.add(phoneNumber);
                    //System.out.println(phoneNumber);
                }
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("*******************************************************");
        System.out.println();

        String devGoldFilePath = "/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/Homework 1/build/classes/main/data_dev/devGOLD";

        File devGOLDFile = new File(devGoldFilePath);

        Set<ContactInformation> goldStandardSet = new HashSet<ContactInformation>();

        Scanner goldFileScanner = null;

        try {
            goldFileScanner = new Scanner(devGOLDFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(goldFileScanner.hasNextLine()){
            String contactString = goldFileScanner.nextLine();

            Scanner contactStringScanner = new Scanner(contactString);

            ContactInformation goldContactInformation = new ContactInformation(contactStringScanner.next(), contactStringScanner.next(), contactStringScanner.next());
            goldStandardSet.add(goldContactInformation);
           // System.out.println(goldContactInformation);

        }

        //        for(ContactInformation foundContactInfo : foundContactInformation){
//            System.out.println(foundContactInfo);
//        }

        //calculate true positives
        int numberOfTruePositive = 0;
        List<ContactInformation> truePositives = new ArrayList<ContactInformation>();

        for(ContactInformation contactInformation : foundContactInformation){
            //System.out.println(contactInformation);
            if(goldStandardSet.contains(contactInformation)){
                numberOfTruePositive++;
                truePositives.add(contactInformation);
            }
        }


        System.out.println("True Positives (" + numberOfTruePositive + ")");
        for(ContactInformation truePositive : truePositives){
            System.out.println(truePositive);
        }

        System.out.println(goldStandardSet.size());
    }
}
