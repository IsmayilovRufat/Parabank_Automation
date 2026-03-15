package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/registration.feature",
        glue = {"steps", "hooks"},
        plugin = {
                "pretty",
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)

public class RegistrationRunner extends AbstractTestNGCucumberTests {}