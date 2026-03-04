package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/registration.feature",
        glue = {"steps", "hooks"},
        plugin = "pretty",
        monochrome = true
)

public class RegistrationRunner extends AbstractTestNGCucumberTests {}