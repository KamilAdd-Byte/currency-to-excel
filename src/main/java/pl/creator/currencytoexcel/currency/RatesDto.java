package pl.creator.currencytoexcel.currency;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
public class RatesDto {
    private String no;
    private String effectiveDate;
    private String mid;

    public RatesDto(String no, String effectiveDate, String mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }
}
