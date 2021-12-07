package pl.creator.currencytoexcel.currency.service.impl;

import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.service.CurrencyService;
import pl.creator.currencytoexcel.currency.webclient.CurrencyWebClient;
import pl.creator.currencytoexcel.currency.webclient.impl.CurrencyWebClientImpl;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyWebClient currencyWebClient;

    public CurrencyServiceImpl(CurrencyWebClientImpl currencyWebClient) {
        this.currencyWebClient = currencyWebClient;
    }
    /**
     * @param code it's currency code standard ISO 4217
     * @return currency and ten rates get to nbp api by rest template
     */
    @Override
    public CurrencyDto getCurrencyLastTenForTableA(String code) {
        return this.currencyWebClient.getCurrencyLastTenTableA(code);
    }
    /**
     * @param code it's currency code standard ISO 4217 from table B
     * @return currency and ten rates get to nbp api by rest template from table B
     */
    @Override
    public CurrencyDto getCurrencyLastTenForTableB(String code) {
        return this.currencyWebClient.getCurrencyLastTenTableB(code);
    }
}
