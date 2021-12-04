package pl.creator.currencytoexcel.currency.write.extract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.webclient.CurrencyWebClient;
import pl.creator.currencytoexcel.currency.write.model.ExtractExcel;
import pl.creator.currencytoexcel.currency.write.pattern.CurrencyPatternForExcelFile;
import pl.creator.currencytoexcel.currency.write.service.WriteService;

import java.io.FileOutputStream;
import java.io.IOException;

@Setter
@Getter
@Slf4j
@NoArgsConstructor
public class CurrencyExtractExcel extends ExtractExcel implements WriteService {
    private CurrencyPatternForExcelFile currencyForExcelFile; //composition
    private XSSFWorkbook workbook;
    private CurrencyDto currencyDto;

    private CurrencyExtractExcel(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public CurrencyExtractExcel(String fileName, XSSFWorkbook workbook, CurrencyDto currencyDto) {
        super(fileName);
        this.workbook = workbook;
        this.currencyDto = currencyDto;
    }

    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
        currencyForExcelFile = new CurrencyPatternForExcelFile();
        if (fileName.toCharArray().length != 0) {
            try (FileOutputStream fileOutput = new FileOutputStream(fileName + ".xlsx")) {
                workbook = currencyForExcelFile.createNewExcelFile(fileName);
                currencyForExcelFile.exportCurrencyToExcel(currencyDto);
                workbook.write(fileOutput);
                workbook.close();
                log.info("Workbook created successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    /**
     * @param currencyDto its dto currency by nbp api
     * @see CurrencyWebClient
     */
    @Override
    public void setCurrencyToWrite(CurrencyDto currencyDto) {
        setCurrencyDto(currencyDto);
    }
}
