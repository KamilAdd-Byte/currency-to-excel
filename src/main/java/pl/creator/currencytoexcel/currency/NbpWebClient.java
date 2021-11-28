package pl.creator.currencytoexcel.currency;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.creator.currencytoexcel.connect.UrlConnection;
import pl.creator.currencytoexcel.connect.WebClient;

@Slf4j
@Getter
@Setter
/**
 * This class is responsible for nbp api connection
 */
public class NbpWebClient extends WebClient implements UrlConnection {
    //url model: https://api.nbp.pl/api/exchangerates/rates/A/USD/last/10
    private static  final  String BASIC_NBP_URL = "https://api.nbp.pl/api/exchangerates/rates";
    private static final String TABLE = "/A/";
    private static final String LAST_TOP_10 = "/last/10";
    private static String nbpUrl;

    /**
     * @param code it's currency code standard ISO 4217
     * @return final URL nbp api last top ten for one currency
     */
    public static String setUrlLastTenRatesForCurrencyByCode(String code) {
       nbpUrl = "";
        if (code.length()==3){
            nbpUrl = BASIC_NBP_URL+TABLE+code.toUpperCase()+LAST_TOP_10;
            return nbpUrl;
        }else
         log.warn("Your code must be 3 characters np: usd or EUR");

       return nbpUrl;
    }
}
