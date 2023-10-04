package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.testng.AssertJUnit.assertEquals;

public class FileUpload extends BaseClass{

    @Given("user on the main page for navigate to File Upload")
    public void user_on_the_main_page_for_navigate_to_file_upload() throws InterruptedException {
        getDriver().navigate().to(homePage());
        Thread.sleep(2000);
    }

    @Given("user select the File Upload element")
    public void user_select_the_file_upload_element() throws InterruptedException {
        getDriver().findElement(By.linkText("File Upload")).click();
        Thread.sleep(2000);
    }

    @When("user upload file")
    public void user_upload_file() throws InterruptedException {
        getDriver().findElement(By.id("file-upload")).sendKeys(filePath());
        Thread.sleep(1000);
        getDriver().findElement(By.id("file-submit")).click();
        Thread.sleep(1000);
        assertEquals(getDriver().findElement(By.id("uploaded-files")).getText(), "chromedriver.exe", "chromedriver.exe");
        Thread.sleep(2000);
    }
}
