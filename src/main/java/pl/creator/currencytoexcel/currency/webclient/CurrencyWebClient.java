package pl.creator.currencytoexcel.currency.webclient;

import pl.creator.currencytoexcel.currency.CurrencyDto;

public interface CurrencyWebClient {
    CurrencyDto getCurrencyLastTenTableA(String code);
    CurrencyDto getCurrencyLastTenTableB(String code);
    CurrencyDto getCurrencyLastTenTableC(String code);
}
