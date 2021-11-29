package pl.creator.currencytoexcel.currency.webclient;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pl.creator.currencytoexcel.connect.UrlConnection;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.webclient.impl.CurrencyWebClientImpl;
import java.io.IOException;
import java.net.URL;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class CurrencyWebClientImplTest {


    @Test
    void whenWillSetUpUrlByUrlConnectionInterface_thenStatus_200() throws IOException {
        //given
        String someUrl = "https://onet.pl";
        //when
        URL url = UrlConnection.setURLToOpenConnection(someUrl);
        //then
        assertNotNull(url);
        //assured
        when()
                .get(url)
                .then()
                .statusCode(200);
    }

    @Test
    void getCurrencyLastTen() {
        CurrencyWebClientImpl currencyWebClient = new CurrencyWebClientImpl();
        CurrencyDto usd = currencyWebClient.getCurrencyLastTen("USD");
        System.out.println(usd);

    }
}
