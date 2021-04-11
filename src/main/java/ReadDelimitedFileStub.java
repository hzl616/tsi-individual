import java.util.ArrayList;
import java.util.List;

public class ReadDelimitedFileStub implements ReadFile {

    @Override
    public List<String[]> getFileData() {
        return getFileData("stubUser");
    }

    @Override
    public List<String[]> getFileData(String fileName) {
        List<String[]> fileData = new ArrayList<>();
        String[] columns = new String[]{
                "emailAddress", "firstName", "lastName", "password"
        };
        String[] row1 = new String[]{
                "test@test.com", "Test", "Stub", "1234"
        };

        fileData.add(columns);
        fileData.add(row1);

        return fileData;
    }

@Override
    public void setFileDelimitor(String fileDelimitor){

    }

    @Override
    public void setFilePath(String filePath) {

    }
}
