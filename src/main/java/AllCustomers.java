import java.util.ArrayList;
import java.util.List;

public class AllCustomers {
    private List<Customer> listOfCustomers = new ArrayList<Customer>();
    private boolean customersLoaded = false;
    private ReadFile readFile;
    private FileLogger fileLogger;

    public AllCustomers(){

    }

    public void setReadDelimitedFile(ReadFile readFile) {
        this.readFile = readFile;
    }

    public void setFileLogger (FileLogger fileLogger){
        this.fileLogger = fileLogger;
    }

    public List<String[]> loadCustomerData() {
        return readFile.getFileData();
    }

    private List<String[]> loadRawCustomers(){
        ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
        return readDelimitedFile.getFileData("customer.csv");
    }

    private List<Customer>  loadAsCustomers(){
        List<String[]> rawCustomers = loadRawCustomers();
        for (String[] rawCustomer : rawCustomers) {
            listOfCustomers.add( new Customer(rawCustomer[0],rawCustomer[1],rawCustomer[2],rawCustomer[3]));
        }
        customersLoaded = true;
        return listOfCustomers;
    }
    public List<Customer>  getListOfCustomers() {

        if (! customersLoaded){
            loadAsCustomers();
        }
        return listOfCustomers;
    }

}
