package pl.creator.currencytoexcel.workbook.action;

import pl.creator.currencytoexcel.currency.CurrencyDto;
import pl.creator.currencytoexcel.filecreated.actions.FileAction;

public interface WriteCurrency extends FileAction {
    void writeHeaderRow();
    void writeDataRows(CurrencyDto currencyDto);
    void exportCurrencyToExcel();
}
