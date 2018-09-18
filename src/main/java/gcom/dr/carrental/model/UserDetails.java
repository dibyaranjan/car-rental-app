package gcom.dr.carrental.model;

public class UserDetails {
    private String userName;


    private String password;


    private String firstName;


    private String middleName;


    private String lastName;

    public UserDetails(String userName, String password, String firstName, String middleName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
