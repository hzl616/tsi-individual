import java.util.List;
import java.util.Scanner;

public class LogIn {
    private Scanner userInput = new Scanner(System.in);
    private FileLogger fileLoggerActual;
    private ReadFile readDelimitedFile;
    private Customer customer;
    private FileLogger fileLogger;

    public LogIn() {
        
    }


    public void setFileLogger (FileLogger fileLogger){
        this.fileLogger = fileLogger;
    }

    private String input(String message) {
        System.out.println(message);
        return userInput.nextLine();
    }

    public LogIn(String fileName) {
        readDelimitedFile = new ReadDelimitedFile(fileName);
        fileLoggerActual = new FileLoggerActual(fileName) {
        };
    }

    private String getPassword(String emailAddress){
        AllCustomers allCustomers = new AllCustomers();
        String password = "";
        List<Customer> listOfCustomers = allCustomers.getListOfCustomers();
        for (Customer customer :listOfCustomers){
            if (customer.getEmailAddress().equals(emailAddress)){
                password = customer.getPassword();
            }
        }
        return password;
    }


    public void logIn() {
        String emailAddress = input("Enter email address: ");
        String password = getPassword(emailAddress);
        if (password == "") {
            System.out.println("Email not found. Please enter a valid address");
            //add recursive action to prompt email input continuously if email not found
            logIn();
        }
        else if (password.equals(input("Enter password: "))){
            System.out.println("Log in success! Welcome");
        }
        else {
            System.out.println("Access denied - Incorrect password");
        }
    }

    public void logIn(String expectedCustomerEmail, String expectedCustomerPassword) {
    }
}