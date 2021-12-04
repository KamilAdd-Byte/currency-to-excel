package pl.creator.currencytoexcel.currency.write;

import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.write.model.CreateExcelFile;

public interface WritePatternForCurrencyToFile extends CreateExcelFile {

    void writeHeaderRow();

    /**
     * @param currencyDto currency if exists
     */
    void writeDataRows(CurrencyDto currencyDto);

    /**
     * @param currencyDto currency if exists
     */
    void exportCurrencyToExcel(CurrencyDto currencyDto);
}
