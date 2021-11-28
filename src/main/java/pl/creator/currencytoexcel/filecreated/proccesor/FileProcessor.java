package pl.creator.currencytoexcel.filecreated.proccesor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.creator.currencytoexcel.currency.gson.CurrencyConvert;
import pl.creator.currencytoexcel.currency.model.CurrencyDto;
import pl.creator.currencytoexcel.filecreated.actions.FileAction;
import pl.creator.currencytoexcel.workbook.CurrencyPatternWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Base64;

@Slf4j
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
        if (fileName.toCharArray().length!=0){
            try (FileOutputStream fileOutput = new FileOutputStream(fileName+".xlsx")){
                workbook.createSheet(fileName);
                workbook.write(fileOutput);
                log.info("Workbook created successfully");
            } catch (IOException e) {
                log.info("Workbook not created");
                e.printStackTrace();
            }
        }
        return workbook;
    }

    private CurrencyDto getCurrency() throws IOException {
        CurrencyConvert currencyConvert = new CurrencyConvert();
        URLConnection connection = CurrencyConvert.openConnection("eur");
        return currencyConvert.convertCurrencyFromJson(connection);
    }

    /**
     * @param workbook exists Excel file created by user
     * @return String encode workbook file
     */
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

    /**
     * @param encode
     * @return
     */
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
        return "Create a new Excel file: " + fromJson;
    }
}
