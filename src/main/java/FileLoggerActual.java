import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLoggerActual implements FileLogger {

    private String fileName;
    private String filePath = "src/main/resources";

    public FileLoggerActual(){

    }

    public FileLoggerActual (String fileName){
        this.fileName = fileName;
    }

    @Override
    public void write(String writeMessage) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write("\n" + writeMessage);
        } catch (IOException err){
            err.printStackTrace();
        }

    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;

    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
