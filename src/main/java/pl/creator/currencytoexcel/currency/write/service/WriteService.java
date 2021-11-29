package pl.creator.currencytoexcel.currency.write.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.CurrencyDto;

public interface WriteService {
    XSSFWorkbook createNewExcelFile(String fileName);
    void setCurrencyToWrite(CurrencyDto currencyDto);
}
