package pl.creator.currencytoexcel.currency.jsoupcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AbstractJsoupProcessorTest {

    @Test
    @DisplayName("get connection wikipedia and should status 200")
    void getConnectionWikipedia_andShouldStatus_200ok() {
        String url = AbstractJsoupProcessor.getUrlBasicCodeCurrency();

        when()
                .get(url)
                .then()
                .statusCode(200);

    }

    @Test
    @DisplayName("get list codes with wikipedia by jsoup scrapping")
    void getListCodes_withWikipedia_byJsoupScrapping(){

        //then
        assertNotNull(AbstractJsoupProcessor.allCodesIso4217());
        assertAll(
                () -> assertThat(AbstractJsoupProcessor.allCodesIso4217(),notNullValue()),
                () -> assertThat(AbstractJsoupProcessor.allCodesIso4217(),hasSize(540))
          );
    }
}
