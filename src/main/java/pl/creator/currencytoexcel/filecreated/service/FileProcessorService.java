package pl.creator.currencytoexcel.filecreated.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.filecreated.actions.FileAction;
import pl.creator.currencytoexcel.filecreated.proccesor.FileProcessor;

@Service
public interface FileProcessorService extends FileAction {

    FileProcessor createNewFileProcessor();

    @Override
    XSSFWorkbook createNewExcelFile(String fileName);

    @Override
    String encodeWorkbookToString(XSSFWorkbook workbook);

    @Override
    String readFromJson(String encode);
}
