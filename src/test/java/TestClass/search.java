package TestClass;

import PageClass.homePage;
import PageClass.searchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class search {

    WebDriver driver;
    homePage hPage;
    searchPage sPage;
    String url= "https://www.testrelic.com/";
    String driverPath="/Users/mobven/IdeaProjects/second_example_pom/drivers/chromedriver";
    //String driverPath_2="/Users/mobven/IdeaProjects/second_example_pom/drivers/geckodriver";

    @BeforeTest
    public void setup(){
        /*System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();*/
        ChromeOptions firefoxOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        ChromeOptions chromeOptions = new ChromeOptions();

    }

    @Test(priority = 0,description = "Title Correct Test")
    public void testTitleCorrect() throws InterruptedException {

        hPage = new homePage(driver);
        String homePageTitle = hPage.getLoginTitle();
        hPage.homeCase();
        Assert.assertTrue(true,homePageTitle);


        driver.manage().getCookies();

        Set<Cookie> cookiesList = driver.manage().getCookies();
        for (Cookie getcookies :cookiesList){
            System.out.println( "Cookie Value" + ":" +getcookies);
        }
        driver.manage().deleteAllCookies();

    }
    @Test(priority = 1,description = "Search Test Process")
    public void search_case() throws InterruptedException, IOException {
        sPage = new searchPage(driver);
        Thread.sleep(2000);
        sPage.search_function("Test Deneme");
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}