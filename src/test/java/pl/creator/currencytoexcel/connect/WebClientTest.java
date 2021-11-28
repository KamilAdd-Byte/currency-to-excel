package pl.creator.currencytoexcel.connect;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.net.URL;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
class WebClientTest {

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
}
