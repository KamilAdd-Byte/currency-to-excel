package pl.creator.currencytoexcel.currency;

import org.junit.jupiter.api.Test;
import pl.creator.currencytoexcel.connect.UrlConnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NbpWebClientTest {

    @Test
    void setUrlLastTenRatesForCurrencyByCode() throws IOException {
        //given
        NbpWebClient nbpWebClient = new NbpWebClient();
        String urlCurrencyByCode = nbpWebClient.setUrlLastTenRatesForCurrencyByCode("USD");

        //when
        URL url = UrlConnection.setURLToOpenConnection(urlCurrencyByCode);
        //then

        //assured
        when()
                .get(url)
                .then()
                .statusCode(200);
    }
}
