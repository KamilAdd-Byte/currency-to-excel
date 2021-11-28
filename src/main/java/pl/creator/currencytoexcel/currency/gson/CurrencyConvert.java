package pl.creator.currencytoexcel.currency.gson;

import com.google.gson.Gson;
import pl.creator.currencytoexcel.connect.UrlConnection;
import pl.creator.currencytoexcel.currency.NbpWebClient;
import pl.creator.currencytoexcel.currency.model.CurrencyDto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * This class preparing CurrencyDto to write Excel file
 */
public class CurrencyConvert extends NbpWebClient {
    private static Gson gson;
    private BufferedReader reader;

    /**
     * @param code it's currency code standard ISO 4217
     * @return open connection for nbp api last top ten for one currency
     * @throws IOException valid connection
     * @see UrlConnection interface
     */
    public static URLConnection openConnection(String code) throws IOException {
        try {
            String urlByCode = setUrlLastTenRatesForCurrencyByCode(code);
            URL urlToOpenConnection = UrlConnection.setURLToOpenConnection(urlByCode);
            return UrlConnection.openConnection(urlToOpenConnection);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        throw new FileNotFoundException();
    }

    /**
     * @param connection open connection for nbp api last top ten for one currency
     * @return converting CurrencyDto from JSON
     */
    public CurrencyDto convertCurrencyFromJson (URLConnection connection){
        String jsonLine = "";
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
