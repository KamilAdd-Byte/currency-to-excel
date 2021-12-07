package pl.creator.currencytoexcel.currency.write.service;

import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.write.model.CreateExcelFile;

public interface WriteService extends CreateExcelFile {
    /**
     * @param currencyDto currency and ten rates get to nbp api by rest template
     * @see pl.creator.currencytoexcel.currency.webclient.CurrencyWebClient
     */
    void setCurrencyToWrite(CurrencyDto currencyDto);
}
