package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.AssertJUnit.assertEquals;

public class HorizontalSlider extends BaseClass {

    @Given("user on the main page for navigate to Horizontal Slider")
    public void user_on_the_main_page_for_navigate_to_horizontal_slider() throws InterruptedException {
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
    }

    @Given("user select the Horizontal Slider element")
    public void user_select_the_horizontal_slider_element() throws InterruptedException {
        getDriver().findElement(By.linkText("Horizontal Slider")).click();
        Thread.sleep(2000);
    }

    @When("user set slider range")
    public void user_set_slider_range() throws InterruptedException {
        WebElement slider = getDriver().findElement(By.cssSelector("input[type='range']"));
        slider.click();
        Thread.sleep(1000);
        int numPresses = (int) (3 * 2);

        Actions action = new Actions(getDriver());
        for (int i = 0; i < numPresses; i++) {

            action.sendKeys(Keys.ARROW_RIGHT).perform();
            action.sendKeys(Keys.ARROW_LEFT).perform();

        }
        action.sendKeys(Keys.ARROW_RIGHT).perform();

        assertEquals(getDriver().findElement(By.id("range")).getText(), String.valueOf(3), String.valueOf(3));
    }
}
