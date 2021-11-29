package pl.creator.currencytoexcel.currency.model;

import lombok.Getter;
import pl.creator.currencytoexcel.currency.RatesDto;

import java.util.List;

@Getter
public class NbpTopRatesForCurrencyDto {
    private String table;
    private String currency;
    private String code;
    private List<RatesDto> rates;
}
