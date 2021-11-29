package pl.creator.currencytoexcel.currency.webclient;

import pl.creator.currencytoexcel.currency.CurrencyDto;

public interface CurrencyWebClient {
    CurrencyDto getCurrencyLastTen(String code);
}
