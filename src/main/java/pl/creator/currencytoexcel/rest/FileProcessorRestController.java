package pl.creator.currencytoexcel.rest;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.filecreated.proccesor.FileProcessor;
import pl.creator.currencytoexcel.filecreated.service.FileProcessorService;


import java.io.IOException;
import java.net.URLConnection;

@RestController
public class FileProcessorRestController {

    @Autowired
    FileProcessorService fileProcessorService;

    /**
     * @param fileName it's name file by user request
     * @return String title Excel file and sheet
     */
//    @PostMapping(path = "/file/{fileName}/{code}")
//    public ResponseEntity<CurrencyDto> createNewExcelFile(@PathVariable("fileName") String fileName,@PathVariable("code") String code) throws IOException {
//        CurrencyConvert currencyConvert = new CurrencyConvert();
//        URLConnection urlConnection = CurrencyConvert.openConnection(code);
//        CurrencyDto currencyDto = currencyConvert.convertCurrencyFromJson(urlConnection);
//        CurrencyPatternWorkbook currencyPatternWorkbook = new CurrencyPatternWorkbook();
//        currencyPatternWorkbook.setCurrencyDto(currencyDto);
//        XSSFWorkbook newExcelFile = currencyPatternWorkbook.createNewExcelFile(fileName);
//        currencyPatternWorkbook.setWorkbook(newExcelFile);
//
//        return ResponseEntity.ok().body(currencyDto);
//    }

    /**
     * @param file instance FileProcessor class
     * @return decode (fromJson) String Excel file title nad sheet
     */
    private String prepareExcelToPrintTitle(FileProcessor file) {
        XSSFWorkbook xssfWorkbook = file.getWorkbook();
        String encodeWorkbookToString = file.encodeWorkbookToString(xssfWorkbook);
        return file.readFromJson(encodeWorkbookToString);
    }
}
