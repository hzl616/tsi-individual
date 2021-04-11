public class Customer {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;

    final public static String dataSourceName = "customer";

    public Customer(String emailAddress, String firstName, String lastName, String password) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }

    public String getPassword(){
        return this.password;
    }

}
