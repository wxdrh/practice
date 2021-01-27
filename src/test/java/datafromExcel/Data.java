package datafromExcel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class Data {

    public String excel(String Website) {
        try {
            FileInputStream file = new FileInputStream("TestData.xlsx");
            XSSFWorkbook excel = new XSSFWorkbook(file);
            int k = 0, column = 0;
            XSSFSheet sheet = excel.getSheetAt(0);
            Iterator<Row> row = sheet.iterator();
            Row firstRow = row.next();
            Iterator<Cell> cell = firstRow.cellIterator();
            while (cell.hasNext()) {
                Cell value = cell.next();
                if (value.getStringCellValue().equalsIgnoreCase("Website")) {
                    column = k;
                }
                k++;
            }
            while (row.hasNext()) {
                Row r = row.next();
                if (r.getCell(column).getStringCellValue().equalsIgnoreCase(Website)) {
                    Iterator<Cell> ci = r.cellIterator();
                    ci.next();
                    while (ci.hasNext()) {
                        return ci.next().getStringCellValue();
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String getUrl(String Url) {

        String Website = null;
        try {
        InputStream input = new FileInputStream("target/config.properties");

            Properties prop = new Properties();
            prop.load(input);
            Website = prop.getProperty(Url);

        } catch (Exception e) {
            e.printStackTrace();
        }
return Website;
    }


}


