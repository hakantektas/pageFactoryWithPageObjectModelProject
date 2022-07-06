package TestClass;

import MainFunction.driverSetUp;
import PageClass.homePage;
import PageClass.searchPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class search extends driverSetUp {

    WebDriver driver;
    homePage hPage;
    searchPage sPage;

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
        sPage.search_function("Test Deneme");
    }
}
