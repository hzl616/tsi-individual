import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadCustomerDataTest {

    @Mock
    AllCustomers allCustomers;
    ReadFile readDelimitedFileStub;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        String testCustomerPath = "src/test/resources/testCustomer.csv";

        ReadDelimitedFile testReadDelimitedFile = new ReadDelimitedFile("customer.csv");
        testReadDelimitedFile.setFilePath(testCustomerPath);
        FileLogger fileLogger = new FileLoggerActual ("customer.csv");
        fileLogger.setFilePath(testCustomerPath);

        allCustomers= new AllCustomers();
        allCustomers.setReadDelimitedFile(testReadDelimitedFile);
        allCustomers.setFileLogger(fileLogger);
        readDelimitedFileStub = new ReadDelimitedFileStub();
    }


    @Test
    void readCustomerData() {
        String expectedEmail = "test@test.com";
        List<String[]> actualCustomerData = allCustomers.loadCustomerData();
        String actualEmail = actualCustomerData.get(1)[0];
        assertEquals(actualEmail, expectedEmail);
    }

    @Test
    void getCustomerDataStub() {
        String expectedEmail = "test@test.com";

        allCustomers.setReadDelimitedFile(readDelimitedFileStub);
        List<String[]> actualCustomerData = allCustomers.loadCustomerData();

        String actualEmail = actualCustomerData.get(1)[0];
        assertEquals(actualEmail, expectedEmail);
    }

    @Test
    void readCustomerInputFake(){
        Customer expectedCustomerDetail = generateCustomer();
        LogIn logIn = new LogIn();
        String expectedCustomerEmail = expectedCustomerDetail.getEmailAddress();
        String expectedCustomerPassword = expectedCustomerDetail.getPassword();
        String expectedInsertCustomerString = getCustomerInputString(expectedCustomerEmail, expectedCustomerPassword);

        FakeFileLogger fakeFileLogger = new FakeFileLogger();
        fakeFileLogger.setFilePath("src/test/resources/testCustomer.csv");
        logIn.setFileLogger(fakeFileLogger);
        logIn.logIn(expectedCustomerEmail, expectedCustomerPassword);

        List<String> actualFileContents = fakeFileLogger.getFileData();
        String actualFileFirstCustomer = actualFileContents.get(0);
        assertEquals(actualFileFirstCustomer, expectedInsertCustomerString);
    }

    private Customer generateCustomer() {
        return new Customer("test@email.com",
                "testFirstName",
                "testLastName",
                "testPassword");
    }

    private String getCustomerInputString(String customerEmailAddress, String customerPassword) {
        return customerEmailAddress + ", " + customerPassword;
    }

}