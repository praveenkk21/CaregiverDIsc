package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",
        glue = {"steps"},
        plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json"},
        monochrome=true,
        dryRun=false,
        tags="@GetAPI"
)
public class testRunner {

}
