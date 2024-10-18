package runner;

import static java.util.Objects.requireNonNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "json:target/Reports/cucumber-report.json", "html:target/cucumber/cucumber.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, glue = { "scenarios",
                "hooks" }, features = "src/test/java/scenarios")
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setupBeforeClass() {
        requireNonNull(
                "C:\\Users\\srinath\\Downloads\\New folder (2)\\Frameworks\\ui-tests-automation-Koovers\\src\\test\\resources\\devconfiguration.properties",
                "credentials file not provided");
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
