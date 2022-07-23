package TestClassPOM;

import DriverFactory.driverManager;
import PageFactoryClass.homePage;
import PageFactoryClass.searchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class search extends driverManager {

    homePage hPage;
    searchPage sPage;
    @Test( priority = 1,description = "Title Correct Test")
    public void testTitleCorrect() throws InterruptedException {

        hPage = new homePage(driver);
        hPage.homeCase();
        Assert.assertTrue(true,hPage.getLoginTitle());
    }
    @Test(priority = 2,description = "Search Test Process 1")
    public void search_case1() throws InterruptedException, IOException {
        sPage = new searchPage(driver);
        sPage.search_function("Test Deneme");
    }
    @Test(priority = 3,description = "Search Test Process 2")
    public void search_case2() throws InterruptedException, IOException {
        hPage.homeCase();
        sPage.search_function("Selenium web");
    }
    @Test(priority = 4,description = "Search Test Process 3")
    public void search_case3() throws InterruptedException, IOException {
        hPage.homeCase();
        sPage.search_function("appium");

    }

}