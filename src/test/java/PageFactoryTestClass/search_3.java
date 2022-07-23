package PageFactoryTestClass;

import DriverFactory.driverManager;
import PageFactoryClass.homePage;
import PageFactoryClass.searchPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class search_3 extends driverManager {

    homePage hPage;
    searchPage sPage;

    String url= "https://www.testrelic.com/";
    String driverPath="/Users/mobven/IdeaProjects/second_example_pom/drivers/chromedriver";
    String driverPath_2="/Users/mobven/IdeaProjects/second_example_pom/drivers/geckodriver";


    /*
    Test project written without using Page factory and Page Object Model...
     */


    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        driver=new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

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
    public void search_case1() throws InterruptedException, IOException {
        sPage = new searchPage(driver);
        hPage.homeCase();
        sPage.search_function("Test Deneme");
    }
    @Test(priority = 2,description = "Search Test Process 2")
    public void search_case2() throws InterruptedException, IOException {
        sPage = new searchPage(driver);
        hPage.homeCase();
        sPage.search_function("Selenium web");
    }
    @AfterTest
    public void close(){
        if (driver!=null)
        {
            driver.quit();
        }
    }
}