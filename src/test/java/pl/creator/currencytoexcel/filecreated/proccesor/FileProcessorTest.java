package pl.creator.currencytoexcel.filecreated.proccesor;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
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
    @DisplayName("should set a name for fileProcessor class")
    void shouldSetNameForFileProcessorClass() {
        //given
        FileProcessor file = createNewFile();
        log.info("Created new file " + file.getFileName());
        //then
        assertNotNull(file);
        assertThat(file.getFileName()).as("Set a name file for class fileProcessor is correct").isEqualTo("test_name");
        assertThat(file.getFileName()).as("Set a name file for class fileProcessor is not correct").isNotEqualTo("test_name.xslx");
    }


    @Test
    @DisplayName("should user create new excel file with name+.xslx")
    void shouldUserCreateNewExcelFileWithName() {
        //given
        FileProcessor file = createNewFile();
        //when
        Workbook excel_new_file = file.createNewExcelFile("Excel_new_file");
        log.info("About excel file: " + excel_new_file.toString());
        Workbook workbook = file.getWorkbook();
        log.info("Workbook in class: " + workbook.toString());

        //then
        assertNotNull(excel_new_file);
        assertThat(file.getWorkbook()).isEqualTo(workbook);
       // assertThat(excel_new_file.getName(file.getName())).isEqualTo(file.getName());
    }

    private FileProcessor createNewFile() {
        FileProcessor file = new FileProcessor();
        file.setFileName("test_name");
        file.setWorkbook(new XSSFWorkbook());
        return file;
    }
}
