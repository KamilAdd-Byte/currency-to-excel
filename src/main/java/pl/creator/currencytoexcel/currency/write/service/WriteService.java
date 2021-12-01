package pl.creator.currencytoexcel.currency.write.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.CurrencyDto;

public interface WriteService {
    /**
     * @param fileName name Excel file and sheet set for user
     * @return new Excel file
     */
    XSSFWorkbook createNewExcelFile(String fileName);

    /**
     * @param currencyDto its dto currency by nbp api
     * @see pl.creator.currencytoexcel.currency.webclient.CurrencyWebClient
     */
    void setCurrencyToWrite(CurrencyDto currencyDto);
}
