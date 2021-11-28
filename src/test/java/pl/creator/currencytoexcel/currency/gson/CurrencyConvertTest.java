package pl.creator.currencytoexcel.currency.gson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.creator.currencytoexcel.currency.model.CurrencyDto;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyConvertTest {

    @Test
    @DisplayName("should open connection for nbp api top ten last one currency")
    void shouldOpenConnectionForNbpTopTenLast_oneCurrency() throws IOException {
        //given
        URLConnection connection = CurrencyConvert.openConnection("EUR");
        URL url = connection.getURL();

        when()
                .get(url)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("should get currency from JSON with nbp api")
    void shouldGetCurrencyFromJsonWithNbpApi() throws IOException {
        //given
        CurrencyConvert currencyConvert = new CurrencyConvert();
        URLConnection connection = CurrencyConvert.openConnection("eur");
        CurrencyDto currencyDto = currencyConvert.convertCurrencyFromJson(connection);

        assertNotNull(currencyDto);
        assertThat(currencyDto.getCode()).isEqualTo("EUR");
    }
}
