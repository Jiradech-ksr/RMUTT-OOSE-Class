package atm_assignment;

public class Person {
    private String idCard;
    private String fullName;
    private String gender;

    public Person(String idCard, String fullName, String gender) {
        this.idCard = idCard;
        this.fullName = fullName;
        this.gender = gender;
    }

    public String getIdCard() { return idCard; }
    public String getFullName() { return fullName; }
    public String getGender() { return gender; }
}
