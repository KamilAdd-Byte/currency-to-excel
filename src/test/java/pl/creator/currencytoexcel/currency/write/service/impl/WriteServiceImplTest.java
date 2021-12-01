package pl.creator.currencytoexcel.currency.write.service.impl;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.service.CurrencyService;
import pl.creator.currencytoexcel.currency.service.impl.CurrencyServiceImpl;
import pl.creator.currencytoexcel.currency.webclient.impl.CurrencyWebClientImpl;
import pl.creator.currencytoexcel.currency.write.extract.CurrencyExtractExcel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WriteServiceImplTest {

    // get currency
    CurrencyWebClientImpl client = CurrencyWebClientImpl.getInstance();
    CurrencyService currencyService = new CurrencyServiceImpl(client);


    @Test
    @DisplayName("should create new excel file for name given by user")
    void shouldCreateNewExcelFileForNameGivenByUser() {
        //given
        CurrencyDto lastTen = currencyService.getCurrencyLastTen("eur");
        CurrencyExtractExcel extractExcel = new CurrencyExtractExcel();
        extractExcel.setCurrencyDto(lastTen);
        String fileName = "Test_Name";

        //when
        XSSFWorkbook test_name = extractExcel.createNewExcelFile(fileName);

        //then
        assertNotNull(test_name);
        assertThat(extractExcel.getCurrencyDto().getCode()).isEqualTo("EUR");
        assertThat(test_name.getSheetAt(0).getSheetName()).isEqualTo(fileName);
    }
}
