package PageClassPOM;

import MainFunction.mainFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends mainFunction {

    By cookie_accept_btn = By.xpath("//*[contains(text(),'ACCEPT')]");

    String url= "https://www.testrelic.com/";
/*
    Test project written without using Page factory and Page Object Model...
     */

    public homePage(WebDriver driver){
        this.driver = driver;
    }
    public void cookieAccept() throws InterruptedException {

        if (waitForVisibilityOfElementLocatedBy(cookie_accept_btn).isDisplayed()){

            waitForVisibilityOfElementLocatedBy(cookie_accept_btn).click();
            driver.manage().deleteAllCookies();
        }
        else {
            System.out.println("Cookie buton tıklanamadı");
        }

    }
    public String getLoginTitle() {

        return driver.getTitle();
    }
    public void home(){
        driver.get(url);
        waitForLoad(driver);
    }
    public void homeCase() throws InterruptedException {

        this.cookieAccept();
        this.getLoginTitle();
        this.home();
    }


}