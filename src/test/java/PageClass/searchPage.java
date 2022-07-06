package PageClass;

import MainFunction.mainFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class searchPage {


    WebDriver driver;

    By search_txt = By.xpath("(//*[@type='text' and @class='text-search-home'])");

    By search_btn = By.xpath("//*[contains(text(),'Search now')]");

    mainFunction mFunciton;

    public searchPage(WebDriver driver){
        this.driver=driver;
    }
    public void searchBox(String searchText) throws InterruptedException, IOException {
        Thread.sleep(3000);
        String currentURL= driver.getCurrentUrl();
        System.out.println("Current URL"+ " : " +currentURL);
        driver.findElement(search_txt).sendKeys(searchText);
        Thread.sleep(500);
        mFunciton= new mainFunction(driver);
        mFunciton.captureScreenShots();
    }
    public void searchBtn() throws IOException {
        driver.findElement(search_btn).click();
        mFunciton.captureScreenShots();

    }
    public String getLoginTitle() {
        String currentURL= driver.getCurrentUrl();
        System.out.println("Current URL"+ " : " +currentURL);
        return driver.getCurrentUrl();
    }
    public void  search_function(String searchText) throws InterruptedException, IOException {

        this.searchBox(searchText);

        this.searchBtn();

        this.getLoginTitle();
    }

}