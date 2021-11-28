package pl.creator.currencytoexcel.currency;

import lombok.Getter;
import lombok.Setter;
import pl.creator.currencytoexcel.connect.UrlConnection;
import pl.creator.currencytoexcel.connect.WebClient;

@Getter
@Setter
public class NbpWebClient extends WebClient implements UrlConnection {
    //url model: https://api.nbp.pl/api/exchangerates/rates/A/USD/last/10
    private static  final  String BASIC_NBP_URL = "https://api.nbp.pl/api/exchangerates/rates";
    private static final String TABLE = "/A/";
    private static final String LAST_TOP_10 = "/last/10";
    private static String nbpUrl;


    public static String setUrlLastTenRatesForCurrencyByCode(String code) {
        nbpUrl = BASIC_NBP_URL+TABLE+code+LAST_TOP_10;
        return nbpUrl;
    }
}
