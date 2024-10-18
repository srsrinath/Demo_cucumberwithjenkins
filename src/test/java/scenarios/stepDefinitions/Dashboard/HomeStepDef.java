package scenarios.stepDefinitions.Dashboard;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Dashboard.HomePage;
import pages.Login.LoginPage;
import utilities.ConfigLoader;

public class HomeStepDef {
    public TestContext testContext;
    public ConfigLoader configLoader;
    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homepage;
    public Scenario scenario;

    public HomeStepDef(TestContext testContext) {
        this.testContext = testContext;
        this.configLoader = testContext.configLoader;
        this.driver = testContext.driver;
        this.loginPage = testContext.loginPage;
        this.homepage = testContext.homepage;
        this.scenario = testContext.scenario;
    }

    @When("User click on Refresh Customer list Button.")
    public void userClickOnRefreshCustomerListButton() {
        scenario.log("user click on refresh customer list");
        homepage.clickRefreshCustomerList();
        homepage.waitFor();

    }

    @Then("User click on Refresh Workshop list Button.")
    public void userClickOnRefreshWorkshopListButton() {
        scenario.log("user click on refresh workshop list.");
        homepage.clickRefreshWorkshopList();
        homepage.waitFor();
    }

    @Given("Log into  the DMS with valid credentials")
    public void logIntoTheDMSWithValidCredentials() {
        scenario.log("user in the login page");
        loginPage.goTo(configLoader.getProperty("url"));
        scenario.log("user enter username and password and code.");
        loginPage.loginToApplication(configLoader.getProperty("UserName"), configLoader.getProperty("password"),
                configLoader.getProperty("code"));
        scenario.log("user click on submit button.");
        loginPage.clickSubmit();
        loginPage.waitFor();
    }
}
