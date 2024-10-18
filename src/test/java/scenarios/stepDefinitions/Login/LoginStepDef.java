package scenarios.stepDefinitions.Login;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import pages.Login.LoginPage;
import utilities.ConfigLoader;
import utilities.CredsLoader;

public class LoginStepDef {

    public TestContext testContext;
    public ConfigLoader configLoader;
    public WebDriver driver;
    public LoginPage loginPage;
    public Scenario scenario;
    public CredsLoader credsLoader;

    public LoginStepDef(TestContext testContext) {
        this.credsLoader = testContext.credsLoader;
        this.testContext = testContext;
        this.configLoader = testContext.configLoader;
        this.driver = testContext.driver;
        this.loginPage = testContext.loginPage;
        this.scenario = testContext.scenario;
    }

    @Given("Log In to DMS")
    public void logInToDMS() {
        scenario.log("user into login page.");
        loginPage.goTo(configLoader.getProperty("url1"));
        scenario.log("user enter username and password and code");
        loginPage.loginToApplication(credsLoader.getProperty("username"), credsLoader.getProperty("password"),
                credsLoader.getProperty("code"));
    }

    @Then("User clicks submit button.")
    public void userClicksSubmitButton() {
        scenario.log("user click on submit button.");
        loginPage.clickSubmit();
        loginPage.waitFor();

    }

    @Given("Login to Koovers  site with {string} {string} {string}")
    public void loginToKooversSiteWith(String username, String password, String code) {
        scenario.log("user into login page.");
        loginPage.goTo(configLoader.getProperty("url"));
        scenario.log("user enter username and password and code");
        loginPage.loginToApplication(username, password, code);

        scenario.log("user enter into welcome screen");

    }

    @Then("User click on the submit button.")
    public void userClickOnTheSubmitButton() {
        scenario.log("user click on submit button.");
        loginPage.clickSubmit();
        loginPage.waitFor();
        System.out.println(loginPage.getTextOnElement(By.id("msgtxt")));

    }

    @Given("User enters into welcome screen.")
    public void userEntersIntoWelcomeScreen() {
        loginPage.goTo(configLoader.getProperty("url"));

    }

    @Then("User is able to view LoginID,Password,Code and submit button.")
    public void userIsAbleToViewLoginIDPasswordCodeAndSubmitButton() {

        System.out.println(loginPage.getPlaceholderText(driver, "txtLoginId"));
        System.out.println(loginPage.getPlaceholderText(driver, "txtLgPassword"));
        System.out.println(loginPage.getPlaceholderText(driver, "txtCode"));
    }

    @Given("User enter into welcome screen")
    public void userEnterIntoWelcomeScreen() {
        loginPage.goTo(configLoader.getProperty("url"));
    }

    @Then("User clicks on submit button.")
    public void userClicksOnSubmitButton() {
        scenario.log("user click on submit button.");
        loginPage.clickSubmit();
        System.out.println(loginPage.getTextOnElement(By.id("txtCode-error")));
    }

    @Then("User click the  submit button.")
    public void userClickTheSubmitButton() {
        System.out.println("user is able to login multiple times with in same browser");
    }

    @Given("Log into the Koovers with valid credentials by open another tab")
    public void logIntoTheKooversWithValidCredentialsByOpenAnotherTab() {
        scenario.log("user into login page.");
        loginPage.goTo(configLoader.getProperty("url"));
        scenario.log("user enter username and password and code ");
        loginPage.loginToApplication(configLoader.getProperty("UserName"), configLoader.getProperty("password"),
                configLoader.getProperty("code"));
        scenario.log("user click on submit button.");
        loginPage.clickSubmit();
        loginPage.waitFor();
        testContext.driver.switchTo().newWindow(WindowType.TAB);
        loginPage.goTo(configLoader.getProperty("url"));
        scenario.log("user into login page.");
        scenario.log("user enter username and password and code");
        loginPage.loginToApplication(configLoader.getProperty("UserName"), configLoader.getProperty("password"),
                configLoader.getProperty("code"));
        scenario.log("user click on submit button.");
        loginPage.clickSubmit();

    }

    @Given("Log into the Koovers with Invalid credentials.")
    public void logIntoTheKooversWithInvalidCredentials() {
        scenario.log("user into login page.");
        loginPage.goTo(configLoader.getProperty("url"));
        scenario.log("user enter username and password and code");
        loginPage.loginToApplication(configLoader.getProperty("Username"), configLoader.getProperty("password"),
                configLoader.getProperty("code"));
    }

}
