package pl.creator.currencytoexcel.currency.write.model;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface CreateExcelFile {
    /**
     * @param fileName name Excel file and sheet set for user
     * @return new Excel fileName.xlsx
     */
    XSSFWorkbook createNewExcelFile(String fileName);
}
