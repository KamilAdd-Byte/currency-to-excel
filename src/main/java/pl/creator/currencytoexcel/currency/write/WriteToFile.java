package pl.creator.currencytoexcel.currency.write;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.CurrencyDto;

public interface WriteToFile {
    /**
     * @param fileName name Excel file and sheet set for user
     * @return new Excel file
     */
    XSSFWorkbook createNewExcelFile(String fileName);

    void setCurrencyToWrite(CurrencyDto currencyDto);


    void writeHeaderRow();

    /**
     * @param currencyDto CurrencyDto if exists
     */
    void writeDataRows(CurrencyDto currencyDto);

    void exportCurrencyToExcel();
}
