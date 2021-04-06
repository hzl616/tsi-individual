import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.spy;;
import static org.mockito.Mockito.when;


class MockDelimitedFileTest {

    @Test
    void setFileDelimitorMock() {
        List<String[]> mockData = new ArrayList<>();
        String[] row1 = new String[]{
                "mock@email.com", "Mock", "Test", "1234"
       };
        mockData.add(row1);
        ReadDelimitedFile readDelimitedFileMock = spy(ReadDelimitedFile.class);
        when(readDelimitedFileMock.getFileData("customers.csv")).thenReturn(mockData);
    }
}