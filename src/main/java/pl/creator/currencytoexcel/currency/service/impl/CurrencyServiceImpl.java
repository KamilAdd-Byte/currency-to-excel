package pl.creator.currencytoexcel.currency.service.impl;

import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.service.CurrencyService;
import pl.creator.currencytoexcel.currency.webclient.CurrencyWebClient;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyWebClient currencyWebClient;

    public CurrencyServiceImpl(CurrencyWebClient currencyWebClient) {
        this.currencyWebClient = currencyWebClient;
    }
    /**
     * @param code code its currency code standard ISO 4217
     * @return CurrencyDto object get to nbp api
     */
    @Override
    public CurrencyDto getCurrencyLastTen(String code) {
        return this.currencyWebClient.getCurrencyLastTen(code);
    }
}
