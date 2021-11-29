package pl.creator.currencytoexcel.currency.write.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.RatesDto;
import pl.creator.currencytoexcel.currency.write.WriteToFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Setter
@Getter
@Slf4j
@NoArgsConstructor
public class CurrencyExtractExcel implements WriteToFile {
      private XSSFWorkbook workbook;
      private XSSFSheet sheet;
      private XSSFRow row;
      private CurrencyDto currencyDto;


    public CurrencyExtractExcel(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
         workbook = new XSSFWorkbook();
        if (fileName.toCharArray().length != 0) {
            try (FileOutputStream fileOutput = new FileOutputStream(fileName + ".xlsx")) {
                sheet = workbook.createSheet(fileName);
                exportCurrencyToExcel();
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

    @Override
    public void writeHeaderRow() {
        row = sheet.createRow(0);
        writePatternForCurrencyTopLastTen();
    }

    private void writePatternForCurrencyTopLastTen() {
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

    @Override
    public void writeDataRows(CurrencyDto currencyDto) {
        int rowCount = 1;
        int rowCountForRates = 2;
        writeValueToPatternForCurrencyTopLastTen(currencyDto, rowCount);
        // get rates
        getRates(currencyDto, rowCountForRates);
    }

    private void writeValueToPatternForCurrencyTopLastTen(CurrencyDto currencyDto, int rowCount) {
        XSSFRow row = sheet.createRow(rowCount);

        XSSFCell cell = row.createCell(0);
        cell.setCellValue(currencyDto.getTable());

        cell = row.createCell(1);
        cell.setCellValue(currencyDto.getCurrency());

        cell = row.createCell(2);
        cell.setCellValue(currencyDto.getCode());
    }

    private void getRates(CurrencyDto currencyDto, int rowCountForRates) {
        XSSFCell cell;
        XSSFRow row;
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
