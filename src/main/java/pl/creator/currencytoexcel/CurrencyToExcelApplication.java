package pl.creator.currencytoexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CurrencyToExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyToExcelApplication.class, args);
    }

}
