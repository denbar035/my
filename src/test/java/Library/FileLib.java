package Library;

import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

/**
 * Created by denys on 4/7/18.
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
}
