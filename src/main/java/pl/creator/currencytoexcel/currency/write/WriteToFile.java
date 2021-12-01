package pl.creator.currencytoexcel.currency.write;

import pl.creator.currencytoexcel.currency.CurrencyDto;

public interface WriteToFile {

    void writeHeaderRow();

    /**
     * @param currencyDto CurrencyDto if exists
     */
    void writeDataRows(CurrencyDto currencyDto);

    /**
     * @param currencyDto CurrencyDto if exists
     */
    void exportCurrencyToExcel(CurrencyDto currencyDto);
}
