package scenarios.stepDefinitions.Customer;

import context.TestContext;
import dbhelper.DbExecutor;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Customer.CustomerPage;
import pages.Customer.SearchByCodePage;
import pages.Dashboard.HomePage;
import pages.Login.LoginPage;
import utilities.ConfigLoader;

public class SearchByCodeStepDef {
    public ConfigLoader configLoader;
    public TestContext testContext;
    public SearchByCodePage searchByCodePage;
    public Scenario scenario;
    public CustomerPage customerPage;
    public LoginPage loginPage;

    public SearchByCodeStepDef(TestContext testContext) {
        this.loginPage = testContext.loginPage;
        this.testContext = testContext;
        this.configLoader = testContext.configLoader;
        this.searchByCodePage = testContext.searchByCodePage;
        this.scenario = testContext.scenario;
        this.customerPage = testContext.customerPage;

    }

    @Given("Log into DMS with {string} {string} {string}")
    public void logIntoDMSWith(String username, String password, String code) {
        loginPage.goTo(configLoader.getProperty("url"));
        loginPage.loginToApplication(username, password, code);
        loginPage.clickSubmit();

    }

    @When("User click on Customer New option.")
    public void userClickOnCustomerNewOption() {
        customerPage.waitFor();
        customerPage.HamburgerIcon();
        customerPage.waitFor();
        customerPage.customerTab();
        scenario.log("user click on customer tab");
        customerPage.waitFor();
        customerPage.goTo(configLoader.getProperty("Customer_url"));
        Assert.assertTrue(true);
        scenario.log("User clicks on customer new option");

    }

    @Then("User enter customer name in the searchbar.")
    public void userEnterCustomerNameInTheSearchbar() {
        customerPage.waitFor();
        scenario.log("user enter customer name in the search bar");
        customerPage.enteredCustomerName();

    }

    @Then("User click on view icon in inquiry page.")
    public void userClickOnViewIconInInquiryPage() throws InterruptedException {
        customerPage.clickViewIcon();
    }

    @When("User click on Search By code option.")
    public void userClickOnSearchByCodeOption() {
        searchByCodePage.ClickHamburgerIcon();
        searchByCodePage.searchByCode();

    }

    @Then("User enter Customer code in the Customer Inquiry page.")
    public void userEnterCustomerCodeInTheCustomerInquiryPage() {
        searchByCodePage.EnterCusCode();

    }

    @Then("User click on Search button.")
    public void userClickOnSearchButton() {
        searchByCodePage.clickSearchBtn();

    }

    @Then("User enter Customer Name in the Customer Inquiry page.")
    public void userEnterCustomerNameInTheCustomerInquiryPage() {
        searchByCodePage.enterCusName();
    }

    @Then("User enter Mobile Number in the Customer Inquiry page.")
    public void userEnterMobileNumberInTheCustomerInquiryPage() {
        searchByCodePage.enterCusMobile();

    }

    @Then("User enter GSTIN Number in the Customer Inquiry page.")
    public void userEnterGSTINNumberInTheCustomerInquiryPage() {
        searchByCodePage.enterCusGst();
    }

    @Then("User enter City in the Customer Inquiry page.")
    public void userEnterCityInTheCustomerInquiryPage() {
        searchByCodePage.EnterCusCode();
        searchByCodePage.enterCity();

    }

    @Then("User enter customer code and customer name and mobile number and GSTIN and City in the Customer Inquiry page.")
    public void userEnterCustomerCodeAndCustomerNameAndMobileNumberAndGSTINAndCityInTheCustomerInquiryPage() {
        searchByCodePage.EnterCusCode();
        searchByCodePage.enterCusName();
        searchByCodePage.enterCusGst();
        searchByCodePage.enterCusMobile();
        searchByCodePage.enterCity();
    }

    @Then("User enter City in  Customer Inquiry page.")
    public void userEnterCityInCustomerInquiryPage() {
        searchByCodePage.waitFor();
        searchByCodePage.enterCity();
    }

    @Then("User click on  De-activate button in inquiry page.")
    public void userClickOnDeActivateButtonInInquiryPage() {
        searchByCodePage.clickDeAct();
    }

    @Then("User verify the customer delete alert message and click ok button.")
    public void userVerifyTheCustomerDeleteAlertMessageAndClickOkButton() {
        scenario.log("User verifies the alert message ");
        customerPage.ClickAccept();
        boolean messagetext = customerPage.verifyAlertMessage(configLoader.getProperty("deactivatealertmessage"));
        Assert.assertTrue(messagetext);
    }
}
