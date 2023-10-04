package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"json:target/cucumber.json"},
        features =
                {
                        "src/test/resources/0form_authentication.feature",
                        "src/test/resources/1add_remove_element.feature",
                        "src/test/resources/2forgot_password.feature",
                        "src/test/resources/3key_presses.feature",
                        "src/test/resources/4hovers.feature",
                        "src/test/resources/5horizontal_slider.feature",
                        "src/test/resources/6file_upload.feature",
                        "src/test/resources/7drop_down.feature",
                        "src/test/resources/8context_menu.feature",
                        "src/test/resources/9java_script_alert.feature",


                },
        glue = {"StepDefinitions"},
        dryRun = false

)
public class Run extends AbstractTestNGCucumberTests { }
