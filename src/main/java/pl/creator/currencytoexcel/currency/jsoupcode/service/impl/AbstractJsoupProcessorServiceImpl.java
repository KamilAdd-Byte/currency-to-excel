package pl.creator.currencytoexcel.currency.jsoupcode.service.impl;

import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.currency.jsoupcode.AbstractJsoupProcessor;
import pl.creator.currencytoexcel.currency.jsoupcode.service.AbstractJsoupProcessorService;
import java.util.List;

@Service
public class AbstractJsoupProcessorServiceImpl implements AbstractJsoupProcessorService {

    @Override
    public List<String> allCodesWithWikipedia() {
        return AbstractJsoupProcessor.allCodesIso4217();
    }
}
