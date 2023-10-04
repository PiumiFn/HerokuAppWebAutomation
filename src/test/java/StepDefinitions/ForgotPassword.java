package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class ForgotPassword extends BaseClass{
    @Given("user on the main page")
    public void user_on_the_main_page() throws InterruptedException {
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
    }

    @Then("user select the Forgot Password element")
    public void user_select_the_forgot_password_element() throws InterruptedException {
        getDriver().findElement(By.linkText("Forgot Password")).click();
        Thread.sleep(2000);
    }

    @When("user fill in email with {string}")
    public void user_fill_in_email_with(String string) throws InterruptedException {
        getDriver().findElement(By.id("email")).sendKeys(string);
        Thread.sleep(2000);
    }

    @Then("user click submit")
    public void user_click_submit() throws InterruptedException {
        getDriver().findElement(By.id("form_submit")).click();
        Thread.sleep(2000);
    }
}
