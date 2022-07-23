package TestClassPOM;

import DriverFactory.driverManager;
import PageFactoryClass.homePage;
import PageFactoryClass.searchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class search extends driverManager {

    homePage hPage;
    searchPage sPage;
    @Test( priority = 1,description = "Title Correct Test")
    public void testTitleCorrect() throws InterruptedException {

        hPage = new homePage(driver);
        hPage.homeCase();
        Assert.assertTrue(true,hPage.getLoginTitle());

//        driver.manage().getCookies();
//        Set<Cookie> cookiesList = driver.manage().getCookies();
//        for (Cookie getcookies :cookiesList){
//            System.out.println( "Cookie Value" + ":" +getcookies);
//        }
//        driver.manage().deleteAllCookies();

    }
//    @Test(priority = 2,description = "Search Test Process 1")
//    public void search_case1() throws InterruptedException, IOException {
//        sPage = new searchPage(driver);
//        Thread.sleep(1000);
//        sPage.search_function("Test Deneme");
//        Thread.sleep(1000);
//        hPage.homeCase();
//    }
//    @Test(priority = 3,description = "Search Test Process 2")
//    public void search_case2() throws InterruptedException, IOException {
//
//        Thread.sleep(1000);
//        sPage.search_function("Selenium web");
//        Thread.sleep(1000);
//        hPage.homeCase();
//    }
//    @Test(priority = 4,description = "Search Test Process 3")
//    public void search_case3() throws InterruptedException, IOException {
//
//        Thread.sleep(1000);
//        sPage.search_function("appium");
//        Thread.sleep(1000);
//        hPage.homeCase();
//    }

}