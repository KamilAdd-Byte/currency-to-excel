package pl.creator.currencytoexcel.connect;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
class WebClientTest {

    @Test
    void whenSetUrl_thenStatus_200() throws IOException {
        URL url = WebClient.setURL("https://api.nbp.pl/api/exchangerates/rates/A/USD/last/10");
        URLConnection connection = WebClient.openConnection(url);

        assertNotNull(connection);
        when()
                .get(url)
                .then()
                .statusCode(200);
    }
}
