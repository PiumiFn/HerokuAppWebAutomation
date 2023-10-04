package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;


public class AddRemoveElement extends BaseClass {

    @Given("user on the home page")
    public void user_on_the_home_page() throws InterruptedException {
       getDriver().navigate().to(homePage());
       Thread.sleep(2000);
    }


    @Given("user select the add remove element")
    public void user_select_the_add_remove_element() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
    }

    @When("user click add element")
    public void user_click_add_element() throws InterruptedException {
        getDriver().findElement(By.xpath(" //*[@id=\"content\"]/div/button")).click();
        Thread.sleep(1000);
        if (!getDriver().findElements(By.xpath("//*[@id=\"elements\"]/button[1]")).isEmpty()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

        Thread.sleep(2000);

    }

    @Then("user deleted added element")
    public void user_deleted_added_element() throws InterruptedException {
        getDriver().findElement(By.xpath(" //*[@id=\"elements\"]/button[1]")).click();
        Thread.sleep(1000);
        if(getDriver().findElements(By.xpath("//*[@id=\"elements\"]/button[1]")).isEmpty()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
        Thread.sleep(1000);
    }


}
