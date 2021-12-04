package pl.creator.currencytoexcel.currency.service;

import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.currency.CurrencyDto;

@Service
public interface CurrencyService {
    CurrencyDto getCurrencyLastTen(String code);
}
