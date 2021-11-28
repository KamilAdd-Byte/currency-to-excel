package pl.creator.currencytoexcel.currency.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RatesDto {
    private String no;
    private String effectiveDate;
    private String mid;
}
