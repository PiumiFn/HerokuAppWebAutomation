package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Hovers extends BaseClass {

    @Given("user on the main page for navigate to hovers")
    public void user_on_the_main_page_for_navigate_to_hovers() throws InterruptedException {
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
    }

    @Given("user select the Hovers element")
    public void user_select_the_hovers_element() throws InterruptedException {
        getDriver().findElement(By.linkText("Hovers")).click();
        Thread.sleep(2000);
    }

    @When("user hover over figure to get caption")
    public void user_hover_over_figure_to_get_caption() throws InterruptedException {
        var figure = getDriver().findElements(By.className("figure")).get(0);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(figure).perform();

        var caption = figure.findElement(By.className("figcaption"));
        Thread.sleep(1000);

        assertTrue(caption.isDisplayed());
        Thread.sleep(1000);
        assertEquals(caption.findElement(By.tagName("h5")).getText(), "name: user1", "name: user1");
        Thread.sleep(1000);
        assertEquals(caption.findElement(By.tagName("a")).getText(), "View profile", "View profile");
        Thread.sleep(1000);
        assertTrue( caption.findElement(By.tagName("a")).getAttribute("href").endsWith("/users/1"));
        Thread.sleep(2000);
    }

}
