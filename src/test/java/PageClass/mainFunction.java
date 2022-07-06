package PageClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mainFunction {

    WebDriver driver;
    String folderName;
    DateFormat df;
    public mainFunction(WebDriver driver){
        this.driver= driver;
    }

    public void captureScreenShots() throws IOException {

      folderName="screenshot";
      File f= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

      df = new SimpleDateFormat("dd-MM-yyyy__hh_mm_ssaa");

      new File(folderName).mkdir();

      String file_name = df.format(new Date())+ ".png";
        FileUtils.copyFile(f, new File(folderName+ "/" + file_name));
    }
}
