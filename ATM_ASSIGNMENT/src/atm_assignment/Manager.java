package atm_assignment;

public class Manager extends Person {
    private String username;
    private String password;

    public Manager(String idCard, String fullName, String gender,
                   String username, String password) {
        super(idCard, fullName, gender);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
