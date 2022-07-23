package TestClass;

import DriverFactory.driverManager;
import PageFactory.homePage;
import PageFactory.signUpPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class singUpTest extends driverManager {


    signUpPage signPage;
    homePage hPage;

    @Test(priority = 1,description = "Signup success case ...")
    public void sUpTest() throws IOException, InterruptedException {
        signPage = new signUpPage(driver);
        hPage = new homePage(driver);
        hPage.homeCase();
        signPage.signUpFuncion("muh.hakantektas3@gmail.com","mtektest","123456Aa.*");
    }

}