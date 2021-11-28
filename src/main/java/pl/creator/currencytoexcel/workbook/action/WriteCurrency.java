package pl.creator.currencytoexcel.workbook.action;

import pl.creator.currencytoexcel.currency.model.CurrencyDto;
import pl.creator.currencytoexcel.filecreated.actions.FileAction;

import java.io.FileOutputStream;

public interface WriteCurrency extends FileAction {
    void writeHeaderRow();
    void writeDataRows(CurrencyDto currencyDto);
    void exportCurrencyToExcel();
}
