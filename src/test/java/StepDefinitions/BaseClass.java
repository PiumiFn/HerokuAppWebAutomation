package StepDefinitions;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;


public class BaseClass {
    private static WebDriver driver;


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    String homePage() {
        return "https://the-internet.herokuapp.com/";
    }

    String filePath() {
        return "C:\\Users\\wpf\\IdeaProjects\\WebAutomation\\src\\test\\resources\\drivers\\chromedriver.exe";
    }


    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();

    }
}
