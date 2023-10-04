package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Dropdown extends BaseClass{

    @Given("user on the main page for navigate to Dropdown")
    public void user_on_the_main_page_for_navigate_to_dropdown() throws InterruptedException{
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
    }

    @Given("user select the Dropdown element")
    public void user_select_the_dropdown_element() throws InterruptedException{
        getDriver().findElement(By.linkText("Dropdown")).click();
        Thread.sleep(2000);
    }

    @When("user select from dropdown")
    public void user_select_from_dropdown() throws InterruptedException{
        new Select(getDriver().findElement( By.id("dropdown"))).selectByVisibleText("Option 1");
        Thread.sleep(2000);
    }

    @When("get user selected options")
    public void get_user_selected_options() throws InterruptedException{
        List<WebElement> selectedElements = new Select(getDriver().findElement( By.id("dropdown"))).getAllSelectedOptions();
        var selectedOptions = selectedElements.stream().map(WebElement::getText).toList();
        Thread.sleep(1000);
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");

        assertTrue(selectedOptions.contains("Option 1"), "Option not selected");
        Thread.sleep(2000);
    }
}
