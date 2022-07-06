
# Project Title


How to do Web Automation Tests with Page Object Model, Java 1.8, Selenium 3.141.59

  
## Usage/Examples

```java
// Create a class constructor searchPage
public searchPage(WebDriver driver){
        this.driver=driver;
    }

// Create an object of class searchPage (This will call the constructor)
```

  searchPage sPage;


```java

@Test(priority = 1,description = "Search Test Process")
public void search_case() throws InterruptedException, IOException {
        sPage = new searchPage(driver);
        sPage.search_function("Test Deneme");
    }


```java
// The primary use of WebDriverManager is the automation of driver management. For using this feature, 
you need to select a given manager in the WebDriverManager API (e.g., chromedriver() for Chrome) and invoke the method setup().
@BeforeTest
    public void setup(){
       ChromeOptions chromeOptions = new ChromeOptions();
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver(chromeOptions);
    }
https://github.com/bonigarcia/webdrivermanager




## Optimization

POM is preferred to improve code maintainability and readability by setting common methods and elements to a variable.



## Lessons Learned
In case of browser incompatibility with the driver that you have used locally, use an updated browser and update your driver.
If you do not want to encounter such problems, you can use the WebDriverManager made by bonigarcia. -> https://github.com/bonigarcia/webdrivermanager



// ## Related Projects


Here are some related projects


[Awesome README](https://github.com/bonigarcia/webdrivermanager)

  
## Distribution


Run this project to deploy


```terminal
  To run your tests via terminal;
Open terminal in project home directory and run mvn clean install command.
Then run your test with the mvn test command.

mvn clean install

after 

mvn test
```

  
## Badges

[![selenium License](https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Selenium_logo.svg/512px-Selenium_logo.svg.png?20210927154434)](https://www.selenium.dev/)





[![appium License](https://seeklogo.com/images/A/appium-logo-7A2DD5B4E3-seeklogo.com.png)](https://appium.io/)




[![java License](https://upload.wikimedia.org/wikipedia/tr/thumb/2/2e/Java_Logo.svg/558px-Java_Logo.svg.png)](https://www.java.com/tr/download/manual.jsp)



[![testNg License](https://blog.knoldus.com/wp-content/uploads/2020/01/TESTNG.png)](https://testng.org/doc/)

  
