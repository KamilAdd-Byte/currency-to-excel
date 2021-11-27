package pl.creator.currencytoexcel.filecreated.proccesor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.filecreated.actions.FileAction;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@NoArgsConstructor
@Getter
@Setter
public class FileProcessor implements FileAction {
    private XSSFWorkbook workbook;
    private String fileName;
    private String workbookToString;

    public FileProcessor(XSSFWorkbook workbook, String fileName) {
        this.workbook = workbook;
        this.fileName = fileName;
    }

    /**
     * @param fileName it's name Excel file
     * @return new Excel file
     */
    @Override
    public XSSFWorkbook createNewExcelFile(String fileName) {
        workbook = new XSSFWorkbook();
        try (FileOutputStream fileOutput = new FileOutputStream(fileName+".xslx")){
            workbook.createSheet(fileName);
            workbook.write(fileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    @Override
    public String encodeWorkbookToString(XSSFWorkbook workbook) {
        workbookToString = "";
        try(ByteArrayOutputStream binOut = new ByteArrayOutputStream()) {
            workbook.write(binOut);
            workbookToString = Base64.getEncoder().encodeToString(binOut.toByteArray());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbookToString;
    }

    @Override
    public String readFromJson(String encode) {
        String fromJson = "";
        byte[] decode = Base64.getDecoder().decode(workbookToString);
        try(ByteArrayInputStream bis = new ByteArrayInputStream(decode)) {
            XSSFWorkbook receive = new XSSFWorkbook(bis);
            fromJson = receive.getSheetAt(0).getSheetName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fromJson;
    }
}
