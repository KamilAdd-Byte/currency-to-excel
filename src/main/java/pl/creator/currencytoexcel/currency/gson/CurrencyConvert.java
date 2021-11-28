package pl.creator.currencytoexcel.currency.gson;

import com.google.gson.Gson;
import pl.creator.currencytoexcel.connect.UrlConnection;
import pl.creator.currencytoexcel.currency.NbpWebClient;
import pl.creator.currencytoexcel.currency.model.CurrencyDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CurrencyConvert extends NbpWebClient {
    private String jsonLine = "";
    private static Gson gson;
    private BufferedReader reader;

    public static URLConnection openConnection(String code) throws IOException {
        String urlByCode = setUrlLastTenRatesForCurrencyByCode(code);
        URL urlToOpenConnection = UrlConnection.setURLToOpenConnection(urlByCode);
        return UrlConnection.openConnection(urlToOpenConnection);
    }

    public CurrencyDto convertCurrencyFromJson (URLConnection connection){
        CurrencyDto currencyDto = null;
        gson = new Gson();
        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((jsonLine = reader.readLine()) != null) {
                currencyDto = gson.fromJson(jsonLine,CurrencyDto.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencyDto;
    }
}
