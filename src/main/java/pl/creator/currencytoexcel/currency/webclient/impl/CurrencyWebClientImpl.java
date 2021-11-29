package pl.creator.currencytoexcel.currency.webclient.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.model.NbpTopRatesForCurrencyDto;
import pl.creator.currencytoexcel.currency.webclient.CurrencyWebClient;

@Slf4j
@Component
public class CurrencyWebClientImpl implements CurrencyWebClient {
    //url model: https://api.nbp.pl/api/exchangerates/rates/A/USD/last/10
    private static final  String BASIC_NBP_URL = "https://api.nbp.pl/api/exchangerates/rates";
    private static final String TABLE = "/A/";
    private static final String LAST_TOP_10 = "/last/10";

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * @param code code its currency code standard ISO 4217
     * @return CurrencyDto object get to nbp api
     */
    @Override
    public CurrencyDto getCurrencyLastTen(String code) {
        if (code.length()==3){
            NbpTopRatesForCurrencyDto nbpTopRatesForCurrencyDto = restTemplate.getForObject(BASIC_NBP_URL + TABLE +
                    code + LAST_TOP_10, NbpTopRatesForCurrencyDto.class,code);

            assert nbpTopRatesForCurrencyDto != null;
            log.info("Currency get successfully");
            return CurrencyDto.builder()
                    .table(nbpTopRatesForCurrencyDto.getTable())
                    .currency(nbpTopRatesForCurrencyDto.getCurrency())
                    .code(nbpTopRatesForCurrencyDto.getCode())
                    .rates(nbpTopRatesForCurrencyDto.getRates())
                    .build();

        }
       throw new NullPointerException();
    }
}
