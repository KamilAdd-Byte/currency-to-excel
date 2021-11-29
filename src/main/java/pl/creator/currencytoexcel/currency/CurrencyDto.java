package pl.creator.currencytoexcel.currency;

import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
public class CurrencyDto {
    private String table;
    private String currency;
    private String code;
    private List<RatesDto> rates;
}
