import java.util.List;

public interface ReadFile {
    List<String[]> getFileData();

    List<String[]> getFileData(String fileName);

    void setFileDelimitor(String fileDelimitor);
}
