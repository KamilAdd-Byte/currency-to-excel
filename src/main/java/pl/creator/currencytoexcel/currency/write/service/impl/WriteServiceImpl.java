package pl.creator.currencytoexcel.currency.write.service.impl;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.write.extract.CurrencyExtractExcel;
import pl.creator.currencytoexcel.currency.write.service.WriteService;

@Service
public class WriteServiceImpl implements WriteService {

    CurrencyExtractExcel currencyExtractExcel = new CurrencyExtractExcel();

    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
        return this.currencyExtractExcel.createNewExcelFile(fileName);
    }

    @Override
    public void setCurrencyToWrite(CurrencyDto currencyDto) {
        this.currencyExtractExcel.setCurrencyDto(currencyDto);
    }
}
