package PageClass;

import MainFunction.mainFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.junit.jupiter.api.Assertions;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static java.lang.Thread.*;

public class signUpPage extends mainFunction{

    By joinUs_btn          = By.xpath("(//*[@class='signup-link open-signup-modal'])");

    By email_txt           = By.xpath("(//*[@id='user_email'])[1]");

    By continue_btn        = By.xpath("//*[contains(text(),'CONTINUE')]");

    By username_txt        = By.xpath("(//*[@id='user_login'])[2]");

    By password_txt        = By.xpath("(//*[@id='user_pass'])[2]");

    By repeat_password_txt = By.xpath("(//*[@id='repeat_pass'])");

    By checkbox            = By.xpath("(//*[@class='checkbox'])");

    By checkbox_2          = By.cssSelector("//span[starts-with(text(), 'I accept')]");

    By join_btn            = By.xpath("(//*[@class=' btn-continue waves-effect waves-light btn-diplomat'])");

    By avatar              = By.xpath("(//*[@class='user-account'])");

    By avatar_2            = By.xpath("(//*[@class='display-name'])");

    By error_message       = By.xpath("(//*[@class='error'])");

    /*
        Test project written without using Page factory and Page Object Model...
         */
    public signUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void joinUsButton(String email) throws IOException {

        String getTitle= driver.getTitle();
        System.out.println("Page Title"+ " : " +getTitle);
        waitForLoad(driver);
        waitForVisibilityOfElementLocatedBy(joinUs_btn).click();
        waitForVisibilityOfElementLocatedBy(email_txt).sendKeys(email);
        waitForVisibilityOfElementLocatedBy(continue_btn).click();
        captureScreenShots();
    }

    public void signUp(String username,String password) throws IOException, InterruptedException {

        waitForLoad(driver);
        waitForVisibilityOfElementLocatedBy(username_txt).sendKeys(username);
        waitForVisibilityOfElementLocatedBy(password_txt).sendKeys(password);
        waitForVisibilityOfElementLocatedBy(repeat_password_txt).sendKeys(password);
        waitForVisibilityOfElementLocatedBy(checkbox).click();
        windowsCloseHanle();
        sleep(3000);
        waitForVisibilityOfElementLocatedBy(checkbox_2).click();
        waitForVisibilityOfElementLocatedBy(join_btn).click();
        captureScreenShots();
    }

    public void signUpControl() throws IOException {

        waitForLoad(driver);
        String getTitle= driver.getTitle();
        System.out.println("Page Title"+ " : " +getTitle);
        boolean deger = waitForVisibilityOfElementLocatedBy(avatar).isDisplayed();
        System.out.println("deger 1  ..."+ deger);
        if (deger == true){
            System.out.println("Başarıyla kayıt olundu ...");
        }
        captureScreenShots();
        boolean deger2 = waitForVisibilityOfElementLocatedBy(avatar_2).isDisplayed();
        System.out.println("deger 2  ..."+ deger2);
        if (deger2 == true){
            System.out.println("Başarıyla kayıt olundu-2 ...");
        }

        Assert.assertEquals(deger,deger2);
        captureScreenShots();


    }
    public void windowsCloseHanle(){
        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();

        // Here we will check if child window has other child windows and when child window
        //is the main window it will come out of loop.
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.close();
                System.out.println("Child window closed");
            }
        }
    }
    public void signUpFailMessage() throws IOException {


        WebElement message= waitForVisibilityOfElementLocatedBy(error_message);
        Assertions.assertTrue(message.getText().contains("valid email address."));//Please enter a valid email address.
        captureScreenShots();


    }
    public void  signUpFuncion(String email,String username,String password) throws IOException, InterruptedException {
        signUpPage signPage = new signUpPage(driver);
        signPage.joinUsButton(email);
        signPage.signUp(username,password);
        signPage.signUpControl();
    }

}