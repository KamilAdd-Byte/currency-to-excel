package pl.creator.currencytoexcel.connect;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootApplication
class WebClientTest {

    @Test
    void setURL() throws MalformedURLException {
        URL url = WebClient.setURL("https://api.nbp.pl/api/exchangerates/rates/A/USD/last/10");
        URLConnection connection = WebClient.openConnection(url);


    }

    @Test
    void openConnection() {
    }
}
