package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static org.testng.AssertJUnit.assertEquals;

public class ContextMenu extends BaseClass{

    @Given("user on the main page for navigate to Context Menu")
    public void user_on_the_main_page_for_navigate_to_context_menu() throws InterruptedException{
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
    }

    @Given("user select the Context Menu element")
    public void user_select_the_context_menu_element() throws InterruptedException{
        getDriver().findElement(By.linkText("Context Menu")).click();
        Thread.sleep(2000);
    }

    @When("user click hot spot")
    public void user_click_hot_spot() throws InterruptedException{
        var button = getDriver().findElement( By.id("hot-spot"));
        Actions action = new Actions( getDriver());
        Thread.sleep(1000);
        action.contextClick(button).perform();
        Thread.sleep(1000);
    }

    @When("get alert message")
    public void get_alert_message() throws InterruptedException{
        String message = getDriver().switchTo().alert().getText();
        Thread.sleep(1000);
        getDriver().switchTo().alert().accept();
        assertEquals(message, "You selected a context menu", "You selected a context menu");
        Thread.sleep(2000);
    }

}
