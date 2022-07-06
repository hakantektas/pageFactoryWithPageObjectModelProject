package MainFunction;

import PageClass.homePage;
import PageClass.searchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class driverSetUp {


    WebDriver driver;
    searchPage sPage;
    homePage hPage;
    String url= "https://www.testrelic.com/";
    String driverPath="/Users/mobven/IdeaProjects/second_example_pom/drivers/chromedriver";
    //String driverPath_2="/Users/mobven/IdeaProjects/second_example_pom/drivers/geckodriver";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
       /* FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().MainFunction.driverSetUp.MainFunction.driverSetUp();
        driver=new FirefoxDriver(firefoxOptions);*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterTest
    public void close(){
        driver.quit();
    }

}
