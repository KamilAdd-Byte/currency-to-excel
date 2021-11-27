package pl.creator.currencytoexcel.filecreated.actions;

import org.apache.poi.ss.usermodel.Workbook;

public interface FileAction {
    Workbook createNewExcelFile(String fileName);
}
