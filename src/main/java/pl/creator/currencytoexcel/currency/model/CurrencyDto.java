package pl.creator.currencytoexcel.currency.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CurrencyDto {
    private String table;
    private String currency;
    private String code;
    private List<RatesDto> rates;
}
