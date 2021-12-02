package pl.creator.currencytoexcel.currency.jsoupcode.rest;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestAbstractJsoupProcessor {
    ResponseEntity<List<String>> getAllCodes();
}
