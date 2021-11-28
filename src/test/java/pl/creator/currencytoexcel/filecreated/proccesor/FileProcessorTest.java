package pl.creator.currencytoexcel.filecreated.proccesor;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class FileProcessorTest {


    @AfterEach
    public void removeFile(){
        //after test remove created file
    }

    @Test
    @DisplayName("should set a name for fileProcessor fileName field")
    void shouldSetNameForFileProcessorFileName() {
        //given
        FileProcessor file = createNewFileProcessor();
        file.setFileName("test_name");
        log.info("Created new fileProcessor and set fields fileName: " + file.getFileName());
        //then
        assertNotNull(file);
        assertThat(file.getFileName()).as("Set a name file for class fileProcessor is correct").isEqualTo("test_name");
        assertThat(file.getFileName()).as("Set a name file for class fileProcessor is not correct").isNotEqualTo("test_name.xlsx");
    }


    @Test
    @DisplayName("should user create new excel file and name file it's name sheet workbook")
    void shouldUserCreateNewExcelFileWithNameInFileProcessorClass() {
        //given
        FileProcessor file = getProcessor();
        //when
        XSSFWorkbook fileWorkbook = file.getWorkbook();
        log.info("About excel file: " + fileWorkbook.toString());
        //then
        assertNotNull(fileWorkbook);
        assertThat(file.getWorkbook()).isEqualTo(fileWorkbook);
        assertThat(fileWorkbook.getSheetAt(0).getSheetName()).isEqualTo("excel");
    }

    private FileProcessor getProcessor() {
        FileProcessor file = new FileProcessor();
        file.createNewExcelFile("excel");
        return file;
    }

    @Test
    @DisplayName("should encode workbook to string")
    void shouldEncodeWorkbookToString() {
        //given
        FileProcessor file = getProcessor();
        XSSFWorkbook workbook = file.getWorkbook();
        String encodeWorkbookToString = file.encodeWorkbookToString(workbook);
        log.info("Encode workbook: " + encodeWorkbookToString);
    }

    @Test
    @DisplayName("should read from json")
    void shouldReadFromJson() {
        FileProcessor file = createNewFileProcessor();
        XSSFWorkbook workbook = file.getWorkbook();
        String encodeWorkbookToString = file.encodeWorkbookToString(workbook);
        log.info("Encode workbook: " + encodeWorkbookToString);
        String readFromJson = file.readFromJson(encodeWorkbookToString);
        log.info("Decode from Json: " + readFromJson);
    }

    private FileProcessor createNewFileProcessor() {
        FileProcessor file = new FileProcessor();
        XSSFWorkbook workbook = new XSSFWorkbook();
        file.setWorkbook(workbook);
        return file;
    }
}
