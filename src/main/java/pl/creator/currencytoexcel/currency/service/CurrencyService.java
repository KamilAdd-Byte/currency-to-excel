package pl.creator.currencytoexcel.currency.service;

import pl.creator.currencytoexcel.currency.CurrencyDto;

public interface CurrencyService {
    CurrencyDto getCurrencyLastTen(String code);
}
