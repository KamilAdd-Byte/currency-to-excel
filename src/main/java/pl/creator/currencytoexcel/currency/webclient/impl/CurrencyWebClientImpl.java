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
    private static CurrencyWebClientImpl instance;
    //url model: https://api.nbp.pl/api/exchangerates/rates/A/USD/last/10
    private static final  String BASIC_NBP_URL = "https://api.nbp.pl/api/exchangerates/rates";
    private static final String TABLE_A = "/A/";
    private static final String TABLE_B = "/B/";
    private static final String TABLE_C = "/C/";
    private static final String LAST_TOP_10 = "/last/10";

    private final RestTemplate restTemplate = new RestTemplate();

    private CurrencyWebClientImpl() { }

    /**
     * @param code are the three characters that make up the currency code standard ISO 4217
     * @return currency and ten rates get to nbp api by rest template from table A
     */
    @Override
    public CurrencyDto getCurrencyLastTenTableA(String code) {
        return getCurrencyDto(code, TABLE_A);
    }

    private CurrencyDto getCurrencyDto(String code, String table) {
        if (code.length()==3){
            NbpTopRatesForCurrencyDto nbpTopRatesForCurrencyDto = restTemplate.getForObject(BASIC_NBP_URL + table +
                    code.toUpperCase() + LAST_TOP_10, NbpTopRatesForCurrencyDto.class,code);

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

    /**
     * @param code are the three characters that make up the currency code standard ISO 4217
     * @return currency and ten rates get to nbp api by rest template from table B
     */
    @Override
    public CurrencyDto getCurrencyLastTenTableB(String code) {
        return getCurrencyDto(code, TABLE_B);
    }


    /**
     * @param code are the three characters that make up the currency code standard ISO 4217
     * @return currency and ten rates get to nbp api by rest template from table C
     */
    @Override
    public CurrencyDto getCurrencyLastTenTableC(String code) {
        return getCurrencyDto(code, TABLE_C);
    }

    public static CurrencyWebClientImpl getInstance(){
        if (instance == null){
            instance = new CurrencyWebClientImpl();
        }
        return instance;
    }
}
