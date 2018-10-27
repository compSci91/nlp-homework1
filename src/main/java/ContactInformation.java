
public class ContactInformation {
    private String filename;
    private String type;
    private String value;

    @Override
    public int hashCode() {
        int result = filename != null ? filename.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public ContactInformation(String filename, String type, String value) {
        this.filename = filename;
        this.type = type;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof ContactInformation){
            ContactInformation otherContactInformation = (ContactInformation)o;

            return this.filename.equals(otherContactInformation.filename) && this.type.equals(otherContactInformation.type) && this.value.equals(otherContactInformation.value);
        }

        return false;
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ContactInformation that = (ContactInformation) o;
//
//        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;
//        if (type != null ? !type.equals(that.type) : that.type != null) return false;
//        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public String toString(){
        return filename + " " + type + " " + value;
    }
}
