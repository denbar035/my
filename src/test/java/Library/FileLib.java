package Library;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by denys on 4/10/18.
 */
public class FileLib {

    public void writeIntoFile(List<WebElement> list, String file_path){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file_path));
            for (WebElement el : list) {
                out.write(el.getText());
                out.newLine();
            }
            out.close();
        }
        catch(Exception e){}

    }

    public String[] fileReader(String filepath){
        int lines = 0;
//Count how much emails(rows)
        try{
            Scanner s1 = new Scanner(new File(filepath));
            while (s1.hasNextLine()){
                lines = lines + 1;
                s1.next();
            }
            String[] emails = new String[lines];
//Save all emails in array
            Scanner s2 = new Scanner(new File("EmailSending/e-mail.txt"));
            for (int i=0; i<lines; i++){
                emails[i] = s2.next();
            }
            return emails;

        }
        catch (FileNotFoundException e){
            System.out.println("EmailReader Error");
        }
        return null;
    }

    public void writeExcelexisted(String[] title, int[] price, String sheet){
        File src = new File ("ExcelFiles/ExcelDoc.xls");
        Workbook wb = null;
        try {
            FileInputStream stream = new FileInputStream(src);
            wb = new XSSFWorkbook(stream);
        }
        catch(Exception e){}
        //add a new sheet to the workbook
        Sheet sheet1 = wb.createSheet(sheet);
        Row row;
        Cell rowcol1;
        Cell rowcol2;
        for(int i=title.length-1, row_num = 0; i>=0; i--, row_num++){
            row = sheet1.createRow(row_num);
            rowcol1 = row.createCell(0);
            rowcol2 = row.createCell(1);
            rowcol1.setCellValue(title[i]);
            rowcol2.setCellValue(price[i]);
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("ExcelFiles/ExcelDoc.xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeExcelcreate(String[] title, int[] price, String sheet) {
        //create a new workbook
        Workbook wb = new XSSFWorkbook();
        //add a new sheet to the workbook
        Sheet sheet1 = wb.createSheet(sheet);
        Row row;
        Cell rowcol1;
        Cell rowcol2;
        for(int i=title.length-1, row_num = 0; i>=0; i--, row_num++){
            row = sheet1.createRow(row_num);
            rowcol1 = row.createCell(0);
            rowcol2 = row.createCell(1);
            rowcol1.setCellValue(title[i]);
            rowcol2.setCellValue(price[i]);
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("ExcelFiles/ExcelDoc.xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
