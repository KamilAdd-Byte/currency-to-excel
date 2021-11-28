package pl.creator.currencytoexcel.currency.gson;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.creator.currencytoexcel.currency.model.CurrencyDto;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyConvertTest {

    @Test
    void openConnection() throws IOException {
        //given
        URLConnection connection = CurrencyConvert.openConnection("EUR");
        URL url = connection.getURL();

        when()
                .get(url)
                .then()
                .statusCode(200);
    }

    @Test
    void convertCurrencyFromJson() throws IOException {
        //given
        CurrencyConvert currencyConvert = new CurrencyConvert();
        URLConnection connection = CurrencyConvert.openConnection("USD");
        CurrencyDto currencyDto = currencyConvert.convertCurrencyFromJson(connection);

        assertNotNull(currencyDto);
    }
}
