package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class FormAuthentication extends BaseClass {

    @Order(0)
    @Given("browser is open")
    public void browser_is_open() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        setDriver(driver);
    }

    @Order(1)
    @Given("user select the form authentication")
    public void user_select_the_form_authentication() throws InterruptedException {
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
        WebElement element = getDriver().findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a"));
        element.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
        element.click();
    }

    @Order(2)
    @When("user fill in UserName with {string}")
    public void user_fill_in_user_name_with(String email) throws InterruptedException {
        getDriver().findElement(By.id("username")).sendKeys(email);
        Thread.sleep(2000);
    }

    @Order(3)
    @When("user fill in Password with {string}")
    public void user_fill_in_password_with(String password) throws InterruptedException {
        getDriver().findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
    }


    @Order(4)
    @When("hits login")
    public void hits_login() throws InterruptedException {
        getDriver().findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
        Thread.sleep(2000);
    }

    @Order(5)
    @Then("user is navigated to the secure area")
    public void user_is_navigated_to_the_secure_area() throws InterruptedException {
        boolean isSuccess = getDriver().findElement(By.id("flash-messages")).isDisplayed();
        Thread.sleep(2000);

        Assert.assertTrue(isSuccess);
    }

    @Order(6)
    @Given("user sign out from page")
    public void user_sign_out_from_page() {
        getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
    }

    @Order(7)
    @Given("user navigate back to the home page")
    public void user_navigate_back_to_the_home_page() throws InterruptedException {
        getDriver().switchTo().defaultContent();
        Thread.sleep(2000);
    }


}
