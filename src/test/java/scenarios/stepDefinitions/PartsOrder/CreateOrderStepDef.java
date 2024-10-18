package scenarios.stepDefinitions.PartsOrder;

import context.TestContext;
import dbhelper.DbExecutor;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Customer.CustomerPage;
import pages.PartsOrder.BulkUploadPage;
import pages.PartsOrder.CreateOrderPage;
import utilities.ConfigLoader;

import java.util.List;
import java.util.Map;

public class CreateOrderStepDef {
    private DbExecutor dbExecutor;
    public ConfigLoader configLoader;
    public TestContext testContext;
    public CreateOrderPage createOrderpage;
    public BulkUploadPage bulkUploadPage;
    public static String CommonItemsCreatedOrderNum = null;
    public CustomerPage customerPage;
    public Scenario scenario;

    public CreateOrderStepDef(TestContext testContext) {
        this.scenario = testContext.scenario;
        this.customerPage = testContext.customerPage;
        this.dbExecutor = testContext.dbExecutor;
        this.configLoader = testContext.configLoader;
        this.testContext = testContext;
        this.createOrderpage = testContext.createOrderpage;
        this.bulkUploadPage = testContext.bulkUploadPage;
    }

    @When("User lands in Create Order Page and verifies the title of the page.")
    public void userLandsInCreateOrderPageAndVerifiesTheTitleOfThePage() {
        bulkUploadPage.waitFor();
        bulkUploadPage.PartsOrderTab();
        bulkUploadPage.waitFor();
        createOrderpage.createOrder();
        createOrderpage.verifyTitle(configLoader.getProperty("title"));

    }

    @Then("User click on add item button with out entering mandatory details.")
    public void userClickOnAddItemButtonWithOutEnteringMandatoryDetails() {

        createOrderpage.addItem();
    }

    @Then("User verify the error-message of the mandatory fields.")
    public void userVerifyTheErrorMessageOfTheMandatoryFields() {
        Assert.assertEquals(createOrderpage.ErrorMessage(), configLoader.getProperty("error-message"));
        System.out.println(createOrderpage.ErrorMessage());
    }

    @Then("User selects customer name from suggestions.")
    public void userSelectsCustomerNameFromSuggestions() {
        createOrderpage.enterNameTextbox(configLoader.getProperty("customername"));
    }

    @Then("User selects assign To from dropdown list.")
    public void userSelectsAssignToFromDropdownList() {
        createOrderpage.SelectDropdown(configLoader.getProperty("assign"));

    }

    @Then("User enter enquiryNo and click search icon.")
    public void userEnterEnquiryNoAndClickSearchIcon() {
        createOrderpage.ClickSearchIcon(configLoader.getProperty("enquiryNo"));
    }

    @Then("User click on Add item button in the order page.")
    public void userClickOnAddItemButtonInTheOrderPage() {
        createOrderpage.addItem();
    }

    @And("User clicks Common Items Radio Button")
    public void userClicksCommonItemsRadioButton() {
        createOrderpage.ClickCommonItems();

    }

    @Then("User click on add button in the add material popup.")
    public void userClickOnAddButtonInTheAddMaterialPopup() {
        createOrderpage.ClickAddBtn();
    }

    @Then("User enter quantity for the selected parts in the add material popup.")
    public void userEnterQuantityForTheSelectedPartsInTheAddMaterialPopup() {
        createOrderpage.EnterQuantity(configLoader.getProperty("quantity1"), configLoader.getProperty("quantity2"));
    }

    @Then("User click on save order button in the order page.")
    public void userClickOnSaveOrderButtonInTheOrderPage() {
        createOrderpage.waitFor();
        createOrderpage.ClickSaveOrderBtn();
    }

    @Then("User verifies the alert message and click ok button.")
    public void userVerifiesTheAlertMessageAndClickOkButton() {
        createOrderpage.verifyAlertMessage(configLoader.getProperty("Notification_message"));
        List<Map<String, String>> orderResultC = dbExecutor.getOrderDetails("CUSTOMER_ID");
        System.out.println(orderResultC.get(0).get("CUSTOMER_ID"));
        CommonItemsCreatedOrderNum = orderResultC.get(0).get("ORDER_NUM");
        System.out.println("the created order number is" + CommonItemsCreatedOrderNum
                + "using common items in add material section");
        Assert.assertNotNull(orderResultC);

    }

    @Then("User click on Select Vehicle button in add material popup.")
    public void userClickOnSelectVehicleButtonInAddMaterialPopup() {
        createOrderpage.ClickVehicleButton();

    }

    @Then("User select Brand and select Model and select and select Fuel Type and Select Year and select variant.")
    public void userSelectBrandAndSelectModelAndSelectAndSelectFuelTypeAndSelectYearAndSelectVariant() {
        createOrderpage.selectVehicleDetails();
    }

    @Then("User enter Partname and click search button.")
    public void userEnterPartnameAndClickSearchButton() {
        createOrderpage.EnterPartName(configLoader.getProperty("PartName"));
    }

    @Then("User click on add button in  add material popup")
    public void userClickOnAddButtonInAddMaterialPopup() {
        createOrderpage.clickCategory();
        createOrderpage.clickAddBtn();

    }

    @Then("User click on save button in the add material popup")
    public void userClickOnSaveButtonInTheAddMaterialPopup() {

        createOrderpage.ClickSaveBtn();
    }

    @Then("User verify the alert message and click ok button.")
    public void userVerifyTheAlertMessageAndClickOkButton() {
        createOrderpage.verifyAlertMessage(configLoader.getProperty("Notification_message"));
        List<Map<String, String>> orderResultC = dbExecutor.getOrderDetails("CUSTOMER_ID");
        System.out.println(orderResultC.get(0).get("CUSTOMER_ID"));
        System.out.println("the created order number is" + orderResultC.get(0).get("ORDER_NUM")
                + "using common items in add material section");
        Assert.assertNotNull(orderResultC);

    }

    @Then("User clicks on Add item button in the order page for creating order using vehicle number.")
    public void userClicksOnAddItemButtonInTheOrderPageForCreatingOrderUsingVehicleNumber() {
        createOrderpage.addItem();

    }

    @Then("User enter vehicle number in the add material popup.")
    public void userEnterVehicleNumberInTheAddMaterialPopup() {
        createOrderpage.EnterVehicleNumber(configLoader.getProperty("VehicleNumber"));

    }

    @Then("User click on Search icon")
    public void userClickOnSearchIcon() {
        createOrderpage.ClickSearchIcon();

    }

    @Then("User clicks on add button in the add material popup.")
    public void userClicksOnAddButtonInTheAddMaterialPopup() {
        createOrderpage.clickCategory();
        createOrderpage.ClickBtn();
    }

    @Then("User verify the alert messages and click ok button.")
    public void userVerifyTheAlertMessagesAndClickOkButton() {
        createOrderpage.verifyAlertMessage(configLoader.getProperty("Notification_message"));
        List<Map<String, String>> orderResult = dbExecutor.getVehicleOrderDetails("CUSTOMER_CODE");
        System.out.println("the created order number is" + orderResult.get(0).get("ORDER_NUM"));
        System.out.println(
                "the order created using" + orderResult.get(0).get("VEHICLE_NUMBER") + "following vehicle number");
        Assert.assertNotNull(orderResult);
    }

    @Then("User clicks on Add item button in the order page for creating order using part number.")
    public void userClicksOnAddItemButtonInTheOrderPageForCreatingOrderUsingPartNumber() {
        createOrderpage.addItem();

    }

    @Then("User click on partnumber option in add material popup.")
    public void userClickOnPartnumberOptionInAddMaterialPopup() {
        createOrderpage.ClickPartNumber();

    }

//    @Then("User enter part number and click search button.")
//    public void userEnterPartNumberAndClickSearchButton() {
//        createOrderpage.EnterPartNumber(configLoader.getProperty("PartNumber"));
//        createOrderpage.clickAddBtn();
//
//    }

    @Then("User click on save button in the add material.")
    public void userClickOnSaveButtonInTheAddMaterial() {
        createOrderpage.ClickSaveBtn();
        createOrderpage.SelectDropdownMake(configLoader.getProperty("Make"));
    }

    @Then("User verify an alert message and Click ok button.")
    public void userVerifyAnAlertMessageAndClickOkButton() {
        createOrderpage.verifyAlertMessage(configLoader.getProperty("Notification_message"));
        List<Map<String, String>> orderResult = dbExecutor.getVehiclePartNumberOrderDetails("CUSTOMER_CODE");
        System.out.println("the created order number is" + orderResult.get(0).get("ORDER_NUM"));
        System.out.println("the order created using" + orderResult.get(0).get("MAT_CODE") + " of following partnumber");
        System.out.println("the partcode of the Material Name is " + orderResult.get(0).get("MAT_NAME"));
        Assert.assertNotNull(orderResult);
    }

    @Then("User click on save button in the add material popup page.")
    public void userClickOnSaveButtonInTheAddMaterialPopupPage() {
        createOrderpage.waitFor();
        createOrderpage.ClickSave();

    }

    @Then("User enters part number and click search button.")
    public void userEntersPartNumberAndClickSearchButton() {
        createOrderpage.EnterPartNumber(configLoader.getProperty("PartNumber"));
        createOrderpage.ClickSearchIconPartNumber();
        createOrderpage.clickAddBtn1();
    }
}
