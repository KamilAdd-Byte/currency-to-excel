package pl.creator.currencytoexcel.currency.jsoupcode.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AbstractJsoupProcessorService {
    List<String> allCodesWithWikipedia();
}
