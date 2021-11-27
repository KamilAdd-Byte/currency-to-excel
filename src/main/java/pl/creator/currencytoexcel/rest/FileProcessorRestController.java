package pl.creator.currencytoexcel.rest;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.creator.currencytoexcel.filecreated.proccesor.FileProcessor;
import pl.creator.currencytoexcel.filecreated.service.FileProcessorService;

@RestController
public class FileProcessorRestController {

    @Autowired
    FileProcessorService fileProcessorService;

    @PostMapping(path = "/file/{fileName}")
    public ResponseEntity<String> createNewExcelFile(@PathVariable("fileName") String fileName){
        FileProcessor file = fileProcessorService.createNewFileProcessor();
        XSSFWorkbook excelFile = fileProcessorService.createNewExcelFile(fileName);
        file.setWorkbook(excelFile);
        String fromJson = prepareExcelToPrintTitle(file);
        return ResponseEntity.ok().body(fromJson);
    }

    private String prepareExcelToPrintTitle(FileProcessor file) {
        XSSFWorkbook xssfWorkbook = file.getWorkbook();
        String encodeWorkbookToString = file.encodeWorkbookToString(xssfWorkbook);
        String fromJson = file.readFromJson(encodeWorkbookToString);
        return fromJson;
    }
}
