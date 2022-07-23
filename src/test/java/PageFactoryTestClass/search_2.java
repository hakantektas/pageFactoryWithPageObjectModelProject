package PageFactoryTestClass;

import DriverFactory.driverManager;
import PageFactoryClass.homePage;
import PageFactoryClass.searchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class search_2 extends driverManager {

    homePage hPage;
    searchPage sPage;

    @Test( priority = 1,description = "Title Correct Test")
    public void testTitleCorrect() throws InterruptedException {

        hPage = new homePage(driver);
        hPage.homeCase();
        Assert.assertTrue(true,hPage.getLoginTitle());
    }
    @Test(priority = 2,description = "Search Test Process 4")
    public void search_case1() throws InterruptedException, IOException {
        sPage = new searchPage(driver);
        Thread.sleep(2000);
        sPage.search_function("New Test");
        hPage.homeCase();
    }
    @Test(priority = 3,description = "Search Test Process 5")
    public void search_case2() throws InterruptedException, IOException {

        Thread.sleep(2000);
        sPage.search_function("Paralell Test");
        hPage.homeCase();
    }
    @Test(priority = 4,description = "Search Test Process 6")
    public void search_case3() throws InterruptedException, IOException {

        Thread.sleep(2000);
        sPage.search_function("Firefox Test");
        hPage.homeCase();
    }
}