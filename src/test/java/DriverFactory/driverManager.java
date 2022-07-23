package DriverFactory;

import io.appium.java_client.functions.ExpectedCondition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class driverManager {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static int timeout = 30;
    String url= "https://www.testrelic.com/";
    String driverPath="/Users/mobven/IdeaProjects/second_example_pom/drivers/chromedriver";
    String driverPath_2="/Users/mobven/IdeaProjects/second_example_pom/drivers/geckodriver";
    String driverPath_3="/Users/mobven/IdeaProjects/second_example_pom/drivers/operadriver";


    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setup(@Optional("browser") String browser){

        /*System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();*/
        switch (browser){

            case "chrome":{

                System.setProperty("webdriver.chrome.driver",driverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                // WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("start-maximized");
                driver=new ChromeDriver();
                System.out.println("***** Browser is chrome *****");
                waitForLoad(driver);
                driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(url);

                break;
            }
            case "firefox":{

                System.setProperty("webdriver.gecko.driver",driverPath_2);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver=new FirefoxDriver();
                System.out.println("***** Browser is firefox *****");
                waitForLoad(driver);
                driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(url);
                break;
            }
            case "opera":{

                System.setProperty("webdriver.opera.driver",driverPath_3);
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments("start-maximized");
                driver=new OperaDriver();
                System.out.println("***** Browser is opera *****");
                waitForLoad(driver);
                driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(url);
                break;
            }
            case "safari":{

                SafariOptions safariOptions = new SafariOptions();
                driver=new SafariDriver();
                System.out.println("***** Browser is safari *****");
                waitForLoad(driver);
                driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(url);
                break;
            }
            default:{
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                System.out.println("*****browser start Chrome Bonigarcia");
                waitForLoad(driver);
                break;
            }
        }



    }
    protected void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, timeout).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

        /*@Parameters("browser")
        @BeforeClass(alwaysRun = true)
        public void beforeTest(@Optional("browser") String browser) {
        setup(browser);
        waitForLoad(driver);
 }*/

    @AfterTest(alwaysRun = true)
    public void close(){
        if (driver!=null)
        {
            driver.quit();
        }
    }
}
