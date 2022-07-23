package PageFactoryTestClass;

import DriverFactory.driverManager;
import PageFactoryClass.homePage;
import PageFactoryClass.signUpPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class singUpFailTest extends driverManager {


    signUpPage signPage;
    homePage hPage;

    @Test(priority = 1,description = "Signup fail case ...")
    public void sUpTestFail() throws IOException, InterruptedException {
        signPage = new signUpPage(driver);
        hPage = new homePage(driver);
        hPage.homeCase();
        signPage.joinUsButton("muh.hakantektas1@gmail.com");
        signPage.signUpFailMessage();
    }
}