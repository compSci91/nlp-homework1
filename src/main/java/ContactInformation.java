
public class ContactInformation {
    private String filename;
    private String type;
    private String value;

    public ContactInformation(String filename, String type, String value) {
        this.filename = filename;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString(){
        return filename + " " + type + " " + value;
    }
}
