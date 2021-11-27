package pl.creator.currencytoexcel.filecreated.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.filecreated.actions.FileAction;
import pl.creator.currencytoexcel.filecreated.proccesor.FileProcessor;

@Service
public interface FileProcessorService extends FileAction {

    FileProcessor createNewFileProcessor();

    /**
     * @param fileName name Excel file and sheet set for user
     * @return new Excel file
     */
    @Override
    XSSFWorkbook createNewExcelFile(String fileName);

    /**
     * @param workbook existing Excel file
     * @return String value for workbook file name nad sheet prepare to rest view
     */
    @Override
    String encodeWorkbookToString(XSSFWorkbook workbook);

    /**
     * @param encode it's String encode workbook file
     * @return decode workbook title file name and sheet name
     */
    @Override
    String readFromJson(String encode);
}
