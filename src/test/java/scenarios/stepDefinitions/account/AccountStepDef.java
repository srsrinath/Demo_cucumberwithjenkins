package scenarios.stepDefinitions.account;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Login.LoginPage;
import pages.MyAccount.AccountPage;
import utilities.ConfigLoader;

public class AccountStepDef {
    public TestContext testContext;
    public ConfigLoader configLoader;
    public WebDriver driver;
    public AccountPage accountpage;
    public LoginPage loginPage;
    public Scenario scenario;

    public AccountStepDef(TestContext testContext) {
        this.testContext = testContext;
        this.configLoader = testContext.configLoader;
        this.driver = testContext.driver;
        this.loginPage = testContext.loginPage;
        this.accountpage = testContext.accountpage;
        this.scenario = testContext.scenario;
    }

    @When("User click on My account dropdown Button.")
    public void userClickOnMyAccountDropdownButton() {
        accountpage.waitFor();
        scenario.log("user click on my account in the menu list.");
        accountpage.clickAccount();

    }

    @Then("User click on change Password Button.")
    public void userClickOnChangePasswordButton() {
        scenario.log("user click on change password option.");
        accountpage.clickConfirmPassword();
        accountpage.waitFor();
    }

    @Then("User click on Save button.")
    public void userClickOnSaveButton() {
        scenario.log("user click on save button.");
        accountpage.ClickSaveBtn();
        System.out.println(accountpage.getTextOnElement(By.id("txtCurrentPwd-error")));
    }

    @Then("User enter correct current password and new password and wrong confirm password in the text field.")
    public void userEnterCorrectCurrentPasswordAndNewPasswordAndWrongConfirmPasswordInTheTextField() {
        scenario.log("user enter current password and new password and wrong confirm password");
        accountpage.enterPasswordDetails(configLoader.getProperty("currentpassword"),
                configLoader.getProperty("newpassword"), configLoader.getProperty("confirmpassword"));
        accountpage.ClickSaveBtn();
        System.out.println(accountpage.getTextOnElement(By.id("txtConfirmPwd-error")));

    }

    @Then("User enter current password and new password and confirm password in the text fields.")
    public void userEnterCurrentPasswordAndNewPasswordAndConfirmPasswordInTheTextFields() {
        scenario.log("user enter change password,new password,confirm password");
        accountpage.enterPasswordDetails(configLoader.getProperty("currentpassword"),
                configLoader.getProperty("newpassword1"), configLoader.getProperty("confirmpassword1"));
        scenario.log("user click on save button");
        accountpage.ClickSaveBtn();
        scenario.log("user should verify the alert message");
        accountpage.verifyAlertMessage("Password should contain at least one of this");

    }

    @Then("User enters wrong {string} and  Correct {string} and {string}  in the text field")
    public void userEntersWrongAndCorrectAndInTheTextField(String cPwd, String nPwd, String cnPwd) {
        scenario.log("user enter wrong current password and new password and confirm password");
        accountpage.enterPasswordDetails(cPwd, nPwd, cnPwd);
    }

    @Then("User enter current password and new password and confirm password in the text field.")
    public void userEnterCurrentPasswordAndNewPasswordAndConfirmPasswordInTheTextField() {
        accountpage.enterPasswordDetails(configLoader.getProperty("currentpassword"),
                configLoader.getProperty("newpassword2"), configLoader.getProperty("confirmpassword2"));
        accountpage.ClickSaveBtn();
        accountpage.verifyAlertMessage("Password updated");
    }

    @Then("User click on logout button.")
    public void userClickOnLogoutButton() {
        scenario.log("user click on clickLogout option.");
        accountpage.clickLogout();
    }

    @Given("Log into  the DMS with valid credentials.")
    public void logIntoTheDMSWithValidCredentials() {
        scenario.log("user in the login page");
        loginPage.goTo(configLoader.getProperty("url"));
        scenario.log("user enter username and password and code.");
        loginPage.loginToApplication(configLoader.getProperty("UserName"), configLoader.getProperty("password1"),
                configLoader.getProperty("code"));
        scenario.log("user click on submit button.");
        loginPage.clickSubmit();
        loginPage.waitFor();
    }
}
