package pl.creator.currencytoexcel.filecreated.proccesor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.filecreated.actions.FileAction;
import java.io.FileOutputStream;
import java.io.IOException;

@NoArgsConstructor
@Getter
@Setter
public class FileProcessor implements FileAction {
    private Workbook workbook;
    private String name;

    public FileProcessor(Workbook workbook, String name) {
        this.workbook = workbook;
        this.name = name;
    }

    /**
     * @param fileName it's name Excel file
     * @return new Excel file
     */
    @Override
    public Workbook createNewExcelFile(String fileName) {
        workbook = new XSSFWorkbook();
        try (FileOutputStream fileOutput = new FileOutputStream(fileName+".xslx")){
            workbook.write(fileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
}
