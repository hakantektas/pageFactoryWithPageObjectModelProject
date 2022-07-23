package PageClassPOM;

import MainFunction.mainFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class searchPage extends mainFunction{

    By search_txt = By.xpath("(//*[@type='text' and @name='s'])[2]");

    By search_btn = By.xpath("//*[contains(text(),'Search now')]");


    /*
        Test project written without using Page factory and Page Object Model...
         */
    public searchPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchBox(String searchText) throws InterruptedException, IOException {

        String currentURL= driver.getCurrentUrl();
        System.out.println("Current URL"+ " : " +currentURL);
        waitForVisibilityOfElementLocatedBy(search_txt).sendKeys(searchText);
        captureScreenShots();
    }

    public void searchBtn() throws IOException {
        waitForVisibilityOfElementLocatedBy(search_btn).click();
        waitForLoad(driver);
        captureScreenShots();

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