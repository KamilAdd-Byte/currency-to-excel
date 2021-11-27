package pl.creator.currencytoexcel.filecreated.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import pl.creator.currencytoexcel.filecreated.proccesor.FileProcessor;
import pl.creator.currencytoexcel.filecreated.service.FileProcessorService;

@Getter
@Setter
@NoArgsConstructor
@Service
public class FileProcessorServiceImpl implements FileProcessorService {

    FileProcessor file = new FileProcessor();

    @Override
    public FileProcessor createNewFileProcessor() {
        return this.file;
    }

    /**
     * @param fileName name Excel file and sheet set for user
     * @return new Excel file
     */
    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
        return this.file.createNewExcelFile(fileName);
    }

    /**
     * @param workbook existing Excel file
     * @return String value for workbook file name nad sheet prepare to rest view
     */
    @Override
    public String encodeWorkbookToString(XSSFWorkbook workbook) {
        return this.file.encodeWorkbookToString(workbook);
    }

    /**
     * @param encode it's String encode workbook file
     * @return decode workbook title file name and sheet name
     */
    @Override
    public String readFromJson(String encode) {
        return this.file.readFromJson(encode);
    }
}
