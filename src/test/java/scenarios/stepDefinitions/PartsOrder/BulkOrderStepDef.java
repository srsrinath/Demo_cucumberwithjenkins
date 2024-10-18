package scenarios.stepDefinitions.PartsOrder;

import context.TestContext;
import dbhelper.DbExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PartsOrder.BulkUploadPage;
import utilities.ConfigLoader;

import java.util.Map;

public class BulkOrderStepDef {
    public TestContext testContext;
    public ConfigLoader configLoader;
    public BulkUploadPage bulkUploadPage;
    public static String orderNumber;
    public DbExecutor dbExecutor;
    public static String customerName = null;

    public BulkOrderStepDef(TestContext testContext) {
        this.dbExecutor = testContext.dbExecutor;
        this.testContext = testContext;
        this.configLoader = testContext.configLoader;
        this.bulkUploadPage = testContext.bulkUploadPage;
    }

    @When("User lands in Bulk Order Upload Page and verifies the title {string}")
    public void userLandsInBulkOrderUploadPageAndVerifiesTheTitle(String title) {
        bulkUploadPage.PartsOrderTab();
        bulkUploadPage.waitFor();
        bulkUploadPage.PartsOrderOption();
        bulkUploadPage.waitFor();
        bulkUploadPage.verifyTitle(title);
        bulkUploadPage.waitFor();
    }

    @Then("User enters the customers name {string} and uploads the Excel file")
    public void userEntersTheCustomersNameAndUploadsTheExcelFile(String name) {
        customerName = name;
        bulkUploadPage.enterNameTextbox(name);
        bulkUploadPage.clickUploadButton();

    }

    @Then("User verifies the part code and part name")
    public void userVerifiesThePartCodeAndPartName() {
        Assert.assertTrue(bulkUploadPage.verifyData());

    }

    @Then("User clicks on save button and verify the success message {string}")
    public void userClicksOnSaveButtonAndVerifyTheSuccessMessage(String message) {
        bulkUploadPage.clickSaveButton();
        bulkUploadPage.waitFor();
        bulkUploadPage.verifyAlertMessage(message);
        System.out.println("verifies alert message");
        Map<String, String> salesOrderResult = dbExecutor.getsalesOrderDetails(customerName);
        System.out.println("verifies alert message salesOrderResult");
        Assert.assertNotNull(salesOrderResult.get("CUSTOMER_NAME"));
        Assert.assertNotNull(salesOrderResult.get("ORDER_NUM"));
        orderNumber = salesOrderResult.get("ORDER_NUM");
        System.out.println(salesOrderResult.get("ORDER_NUM"));
    }

    @Then("User lands in Estimate Search order page and verifies the order")
    public void userLandsInEstimateSearchOrderPageAndVerifiesTheOrder() {
        bulkUploadPage.goTo(configLoader.getProperty("Estimate_enquiry_url"));
        bulkUploadPage.clickSearchButton();
        bulkUploadPage.waitFor();
        Assert.assertEquals(bulkUploadPage.getOrderNumber(), BulkOrderStepDef.orderNumber);

    }
}
