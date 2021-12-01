package pl.creator.currencytoexcel.currency.write.extract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.write.pattern.CurrencyPatternExcelFile;
import pl.creator.currencytoexcel.currency.write.service.WriteService;

import java.io.FileOutputStream;
import java.io.IOException;

@Setter
@Getter
@Slf4j
@NoArgsConstructor
public class CurrencyExtractExcel implements WriteService {
      private XSSFWorkbook workbook;
      private CurrencyDto currencyDto;

    public CurrencyExtractExcel(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
         CurrencyPatternExcelFile currencyPatternExcelFile = new CurrencyPatternExcelFile();
         workbook = currencyPatternExcelFile.createNewWorkbook(fileName);
        if (fileName.toCharArray().length != 0) {
            try (FileOutputStream fileOutput = new FileOutputStream(fileName + ".xlsx")) {
                currencyPatternExcelFile.exportCurrencyToExcel(currencyDto);
                workbook.write(fileOutput);
                workbook.close();
                log.info("Workbook created successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    @Override
    public void setCurrencyToWrite(CurrencyDto currencyDto) {
        setCurrencyDto(currencyDto);
    }
}
