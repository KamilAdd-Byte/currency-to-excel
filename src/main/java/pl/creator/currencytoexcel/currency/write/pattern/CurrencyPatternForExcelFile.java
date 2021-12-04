package pl.creator.currencytoexcel.currency.write.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.RatesDto;
import pl.creator.currencytoexcel.currency.write.WritePatternForCurrencyToFile;
import pl.creator.currencytoexcel.currency.write.extract.CurrencyExtractExcel;

import java.util.List;

/**
 * This is auxiliary class for write CurrencyDto
 *
 */
@Slf4j
@Getter
@NoArgsConstructor
public class CurrencyPatternForExcelFile implements WritePatternForCurrencyToFile {
    private CurrencyDto currencyDto;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;


    public CurrencyPatternForExcelFile(XSSFWorkbook workbook, CurrencyDto currencyDto) {
        this.workbook = workbook;
        this.currencyDto = currencyDto;
    }

    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(fileName);
        return workbook;
    }

    @Override
    public void exportCurrencyToExcel(CurrencyDto currencyDto) {
        writeHeaderRow();
        writeDataRows(currencyDto);
    }

    @Override
    public void writeHeaderRow() {
        row = sheet.createRow(0);
        writePatternForCurrencyTopLastTen();
    }

    private void writePatternForCurrencyTopLastTen() {
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Tabala");
        setFontAndStyle(cell);
        cell = row.createCell(1);
        cell.setCellValue("Nazwa");

        cell = row.createCell(2);
        cell.setCellValue("KOD");

        cell = row.createCell(3);
        cell.setCellValue("No");

        cell = row.createCell(4);
        cell.setCellValue("Data");

        cell = row.createCell(5);
        cell.setCellValue("Wartość");
    }

    private void setFontAndStyle(XSSFCell cell) {
        Font font = workbook.createFont();
        font.setFontHeight((short) 24);
        font.setBold(true);
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);
        cell.setCellStyle(style);
    }

    @Override
    public void writeDataRows(CurrencyDto currencyDto) {
        if (currencyDto != null){
            int rowCount = 1;
            int rowCountForRates = 2;
            writeValueToPatternForCurrencyTopLastTen(currencyDto, rowCount);
            // get rates
            getRates(currencyDto, rowCountForRates);
            log.info("Currency and ten rates correctly write to file");
        }else {
            log.warn("Currency and ten rates not extracted");
        }
    }


    private void getRates(CurrencyDto currencyDto, int rowCountForRates) {
        XSSFCell cell;
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

    private void writeValueToPatternForCurrencyTopLastTen(CurrencyDto currencyDto, int rowCount) {
        row = sheet.createRow(rowCount);

        XSSFCell cell = row.createCell(0);
        cell.setCellValue(currencyDto.getTable());

        cell = row.createCell(1);
        cell.setCellValue(currencyDto.getCurrency());

        cell = row.createCell(2);
        cell.setCellValue(currencyDto.getCode());
    }
}
