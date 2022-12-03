package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Support {

    public static WebDriver setBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    public static HashMap<String, ArrayList<String>> getAllObjects() {

        HashMap<String, ArrayList<String>> objData = new HashMap<>();
        ArrayList<String> objInnerData;
        try {
            FileInputStream fis = new FileInputStream("src//main//resources//objects.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                objInnerData = new ArrayList<>();
                objInnerData.add(0, row.getCell(1).getStringCellValue().trim());
                objInnerData.add(1, row.getCell(2).getStringCellValue().trim());
                objData.put(row.getCell(0).getStringCellValue().trim(), objInnerData);
                objInnerData = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objData;
    }
}
