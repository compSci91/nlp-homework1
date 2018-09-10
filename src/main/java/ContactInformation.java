
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactInformation that = (ContactInformation) o;

        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public String toString(){
        return filename + " " + type + " " + value;
    }
}
