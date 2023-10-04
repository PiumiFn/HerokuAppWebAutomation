package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.testng.AssertJUnit.assertEquals;

public class JavaScriptAlerts extends BaseClass{

    @Given("user on the main page for navigate to JavaScript Alerts")
    public void user_on_the_main_page_for_navigate_to_java_script_alerts() throws InterruptedException {
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
    }

    @Given("user select the JavaScript Alerts element")
    public void user_select_the_java_script_alerts_element() throws InterruptedException {
        getDriver().findElement(By.linkText("JavaScript Alerts")).click();
        Thread.sleep(2000);
    }

    @When("user test alert")
    public void user_test_alert() throws InterruptedException {
        getDriver().findElement(By.xpath(".//button[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        getDriver().switchTo().alert().accept();
        Thread.sleep(1000);
        assertEquals( getDriver().findElement(By.id("result")).getText(), "You successfully clicked an alert", "You successfully clicked an alert");
        Thread.sleep(2000);
    }

    @When("user test confirm")
    public void user_test_confirm() throws InterruptedException {
        getDriver().findElement( By.xpath(".//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        getDriver().switchTo().alert().dismiss();
        Thread.sleep(1000);
        assertEquals( getDriver().findElement(By.id("result")).getText(), "You clicked: Cancel", "You clicked: Cancel");
        Thread.sleep(2000);
    }

    @When("test confirm accept")
    public void test_confirm_accept() throws InterruptedException {
        getDriver().findElement( By.xpath(".//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        getDriver().switchTo().alert().accept();
        Thread.sleep(1000);
        assertEquals( getDriver().findElement(By.id("result")).getText(),  "You clicked: Ok", "You clicked: Ok");
        Thread.sleep(2000);
    }

    @When("test prompt")
    public void test_prompt() throws InterruptedException {
        getDriver().findElement( By.xpath(".//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        getDriver().switchTo().alert().sendKeys("a message");
        Thread.sleep(1000);
        getDriver().switchTo().alert().accept();
        Thread.sleep(1000);
        assertEquals( getDriver().findElement(By.id("result")).getText(),  "You entered: a message", "You entered: a message");
        Thread.sleep(2000);
    }

    @When("dismiss prompt")
    public void dismiss_prompt() throws InterruptedException {
        getDriver().findElement( By.xpath(".//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        getDriver().switchTo().alert().dismiss();
        Thread.sleep(1000);
        assertEquals( getDriver().findElement(By.id("result")).getText(),  "You entered: null", "You entered: null");
        Thread.sleep(2000);
    }
}
