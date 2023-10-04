package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.testng.AssertJUnit.assertEquals;

public class KeyPresses extends BaseClass{

    @Given("user on the main page for navigate to key presses")
    public void user_on_the_main_page_for_navigate_to_key_presses() throws InterruptedException {
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
    }

    @Given("user select the Key Presses element")
    public void user_select_the_key_presses_element() throws InterruptedException{
        getDriver().findElement(By.linkText("Key Presses")).click();
        Thread.sleep(2000);
    }

    @When("user test back space")
    public void user_test_back_space() throws InterruptedException{
        getDriver().findElement(By.id("target")).sendKeys("A" + Keys.BACK_SPACE);
        Thread.sleep(1000);
        assertEquals(getDriver().findElement(By.id("result")).getText(), "You entered: BACK_SPACE", "You entered: BACK_SPACE");
        Thread.sleep(2000);
    }

    @Then("user test pi")
    public void user_test_pi() throws InterruptedException{
        getDriver().findElement(By.id("target")).sendKeys(Keys.chord(Keys.ALT, Keys.NUMPAD2, Keys.NUMPAD2, Keys.NUMPAD7));
        Thread.sleep(1000);
        assertEquals(getDriver().findElement(By.id("result")).getText(), "You entered: NUMPAD7", "You entered: NUMPAD7");
        Thread.sleep(2000);
    }

}
