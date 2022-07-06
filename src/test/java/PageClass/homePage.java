package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

    WebDriver driver;

    By cookie_accept_btn = By.xpath("//*[contains(text(),'ACCEPT')]");

    public homePage(WebDriver driver){
        this.driver= driver;
    }

    public void cookieAccept() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(cookie_accept_btn).click();
    }

    public String getLoginTitle() {
        String title=driver.getTitle();
        System.out.println("Title Bilgisi" + " : " +title);
        return driver.getTitle();
    }

    public void homeCase() throws InterruptedException {
        this.cookieAccept();
        this.getLoginTitle();
    }


}


