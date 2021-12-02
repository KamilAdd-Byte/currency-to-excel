package pl.creator.currencytoexcel.currency.write.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class ExtractExcel implements CreateExcelFile {
    private String fileName;
    private XSSFWorkbook workbook;

    public ExtractExcel(String fileName,XSSFWorkbook workbook) {
        this.fileName = fileName;
        this.workbook = workbook;
    }

    public ExtractExcel(String fileName) { }

    @Override
    public XSSFWorkbook createNewExcelFile(String fileName){
        workbook = new XSSFWorkbook();
        try (FileOutputStream fileOutput = new FileOutputStream(fileName + ".xlsx")) {
            workbook.write(fileOutput);
            workbook.close();
            log.info("Workbook created successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
}
