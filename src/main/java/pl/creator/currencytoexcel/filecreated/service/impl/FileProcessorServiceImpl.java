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

    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
        return this.file.createNewExcelFile(fileName);
    }

    @Override
    public String encodeWorkbookToString(XSSFWorkbook workbook) {
        return this.file.encodeWorkbookToString(workbook);
    }

    @Override
    public String readFromJson(String encode) {
        return this.file.readFromJson(encode);
    }
}
