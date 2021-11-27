package pl.creator.currencytoexcel.filecreated.actions;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface FileAction {
    XSSFWorkbook createNewExcelFile(String fileName);
    String encodeWorkbookToString(XSSFWorkbook workbook);
    String readFromJson(String encode);
}
