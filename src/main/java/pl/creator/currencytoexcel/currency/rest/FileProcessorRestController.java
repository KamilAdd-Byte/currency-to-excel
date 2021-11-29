package pl.creator.currencytoexcel.currency.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.currency.service.CurrencyService;
import pl.creator.currencytoexcel.currency.write.service.WriteService;

@RestController
public class FileProcessorRestController {

    @Autowired
    WriteService writeService;

    @Autowired
    CurrencyService currencyService;

    /**
     * @param fileName it's name file by user request
     * @return String title Excel file and sheet
     */
    @PostMapping(path = "/file/{fileName}/{code}")
    public ResponseEntity<CurrencyDto> createNewExcelFile(@PathVariable("fileName") String fileName, @PathVariable("code") String code) {
        CurrencyDto currencyDto = currencyService.getCurrencyLastTen(code);
        writeService.setCurrencyToWrite(currencyDto);
        writeService.createNewExcelFile(fileName);
        return ResponseEntity.ok().body(currencyDto);
    }
}
