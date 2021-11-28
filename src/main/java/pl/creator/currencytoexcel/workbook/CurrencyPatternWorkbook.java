package pl.creator.currencytoexcel.workbook;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.model.CurrencyDto;
import pl.creator.currencytoexcel.currency.model.RatesDto;
import pl.creator.currencytoexcel.filecreated.proccesor.FileProcessor;
import pl.creator.currencytoexcel.workbook.action.WriteCurrency;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class CurrencyPatternWorkbook extends FileProcessor implements WriteCurrency {
    private XSSFSheet sheet;
    private XSSFRow row;
    private CurrencyDto currencyDto;

    public CurrencyPatternWorkbook(XSSFWorkbook workbook, XSSFSheet sheet, String fileName, CurrencyDto currencyDto) {
        super(workbook, fileName);
        this.currencyDto = currencyDto;
        this.sheet = sheet;
    }

    @Override
    public void writeHeaderRow() {
        XSSFRow row = sheet.createRow(0);

        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Tabala");

        cell = row.createCell(1);
        cell.setCellValue("Nazwa");

        cell = row.createCell(2);
        cell.setCellValue("KOD");

        cell = row.createCell(3);
        cell.setCellValue("No");

        cell = row.createCell(4);
        cell.setCellValue("Date");

        cell = row.createCell(5);
        cell.setCellValue("Value");
    }

    /**
     * @param fileName it's name Excel file
     * @return new Excel file
     */
    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        if (fileName.toCharArray().length != 0) {
            try (FileOutputStream fileOutput = new FileOutputStream(fileName + ".xlsx")) {
                sheet = workbook.createSheet(fileName);
                writeAndClose(workbook, fileOutput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    private void writeAndClose(XSSFWorkbook workbook, FileOutputStream fileOutput) throws IOException {
        log.info("Workbook created successfully");
        exportCurrencyToExcel();
        workbook.write(fileOutput);
        workbook.close();
        fileOutput.close();
    }

    @Override
    public void writeDataRows(CurrencyDto currencyDto) {
        int rowCount = 1;
        int rowCountForRates = 2;
        XSSFRow row = sheet.createRow(rowCount);

        XSSFCell cell = row.createCell(0);
        cell.setCellValue(currencyDto.getTable());

        cell = row.createCell(1);
        cell.setCellValue(currencyDto.getCurrency());

        cell = row.createCell(2);
        cell.setCellValue(currencyDto.getCode());

        List<RatesDto> ratesDtos = currencyDto.getRates();

        for (RatesDto rate : ratesDtos) {
            row = sheet.createRow(rowCountForRates);
            cell = row.createCell(3);
            cell.setCellValue(rate.getNo());

            cell = row.createCell(4);
            cell.setCellValue(rate.getEffectiveDate());

            cell = row.createCell(5);
            cell.setCellValue(rate.getMid());
            rowCountForRates++;
        }
    }
    @Override
    public void exportCurrencyToExcel() {
        writeHeaderRow();
        writeDataRows(currencyDto);

    }
}
