import java.util.ArrayList;
import java.util.List;

public class FakeFileLogger implements FileLogger {

    private String fileName;
    private String filePath = "src/main/resources";
    public String fullPath;
    private final List<String> fileData = new ArrayList<>();


    public FakeFileLogger(String fileName) {
        this.fileName = fileName;
        this.fullPath = filePath + fileName;
    }

    public FakeFileLogger() {

    }


    public List<String> getFileData() {
        return fileData;
    }

    @Override
    public void write(String writeMessage) {
        fileData.add(writeMessage);

    }


    @Override
    public void setFileName(String fileName) {

    }

    @Override
    public void setFilePath(String filePath) {

    }


}
