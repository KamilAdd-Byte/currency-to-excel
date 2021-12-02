package pl.creator.currencytoexcel.currency.jsoupcode.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.creator.currencytoexcel.currency.jsoupcode.rest.RestAbstractJsoupProcessor;
import pl.creator.currencytoexcel.currency.jsoupcode.service.AbstractJsoupProcessorService;

import java.util.List;

@RestController
public class RestAbstractJsoupProcessorImpl implements RestAbstractJsoupProcessor {

    @Autowired
    AbstractJsoupProcessorService abstractJsoupProcessorService;

    @Override
    @GetMapping("file/codes")
    public ResponseEntity<List<String>> getAllCodes() {
        List<String> allCodesWithWikipedia = abstractJsoupProcessorService.allCodesWithWikipedia();
        return ResponseEntity.ok().body(allCodesWithWikipedia);
    }
}
