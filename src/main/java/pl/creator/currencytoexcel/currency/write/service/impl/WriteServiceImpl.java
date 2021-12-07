package pl.creator.currencytoexcel.currency.write.service.impl;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.write.extract.CurrencyExtractExcel;
import pl.creator.currencytoexcel.currency.write.service.WriteService;

@Service
public class WriteServiceImpl implements WriteService {

    CurrencyExtractExcel currencyExtractExcel = new CurrencyExtractExcel();

    /**
     * @param fileName name Excel file and sheet set for user
     * @return new Excel fileName.xlsx
     */
    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
        return this.currencyExtractExcel.createNewExcelFile(fileName);
    }

    /**
     * @param currencyDto currency and ten rates get to nbp api by rest template
     * @see pl.creator.currencytoexcel.currency.webclient.CurrencyWebClient
     */
    @Override
    public void setCurrencyToWrite(CurrencyDto currencyDto) {
        this.currencyExtractExcel.setCurrencyToWrite(currencyDto);
    }
}
