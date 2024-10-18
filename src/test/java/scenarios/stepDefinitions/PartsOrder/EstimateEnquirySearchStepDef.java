package scenarios.stepDefinitions.PartsOrder;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PartsOrder.BulkUploadPage;
import pages.PartsOrder.CreateOrderPage;
import pages.PartsOrder.EstimateEnquirySearchPage;
import pages.PartsOrder.OrderSearchPage;
import utilities.ConfigLoader;

public class EstimateEnquirySearchStepDef {

    public ConfigLoader configLoader;
    public TestContext testContext;
    public BulkUploadPage bulkUploadPage;
    public Scenario scenario;
    public CreateOrderPage createOrderpage;
    public OrderSearchPage orderSearchPage;
    public EstimateEnquirySearchPage estimateEnquirySearchPage;

    public EstimateEnquirySearchStepDef(TestContext testContext) {
        this.estimateEnquirySearchPage = testContext.estimateEnquirySearchPage;
        this.orderSearchPage = testContext.orderSearchPage;
        this.createOrderpage = testContext.createOrderpage;
        this.scenario = testContext.scenario;
        this.testContext = testContext;
        this.configLoader = testContext.configLoader;
        this.bulkUploadPage = testContext.bulkUploadPage;
    }

    @When("User lands in Estimate Order Search Page and verifies the title of the page.")
    public void userLandsInEstimateOrderSearchPageAndVerifiesTheTitleOfThePage() {
        bulkUploadPage.waitFor();
        bulkUploadPage.PartsOrderTab();
        bulkUploadPage.waitFor();
        estimateEnquirySearchPage.EstimateEnquiry();
        estimateEnquirySearchPage.waitFor();
        estimateEnquirySearchPage.verifyTitle(configLoader.getProperty("title1"));
        scenario.log("User click on estimate order details option");
        scenario.log("User verify the title of the page");
    }

    @Then("User click on New Estimate Order button.")
    public void userClickOnNewEstimateOrderButton() {
        estimateEnquirySearchPage.NewEstimateBtn();
        scenario.log("User click on New Estimate Order Button.");
    }

    @Then("User click on add item button in the Estimate Order Page.")
    public void userClickOnAddItemButtonInTheEstimateOrderPage() {
        estimateEnquirySearchPage.ClickAddItemBtn();
        scenario.log("User click on Add item button in order page.");

    }

    @Then("User Click on Edit Icon in the EstimateOrder Page.")
    public void userClickOnEditIconInTheEstimateOrderPage() {
        estimateEnquirySearchPage.ClickEditIcon();
        estimateEnquirySearchPage.EnterQuan(configLoader.getProperty("EstQuantity"), configLoader.getProperty("text"));
    }

    @Then("User click on Upload Image icon in the estimate Order page.")
    public void userClickOnUploadImageIconInTheEstimateOrderPage() {
        estimateEnquirySearchPage.ClickUploadImage();
        estimateEnquirySearchPage.ClickUploadImageBtn();
        estimateEnquirySearchPage.waitFor();
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("NotificationMessage2"));
        Assert.assertTrue(true);
        estimateEnquirySearchPage.CloseIcon();
    }

    @Then("User enter customer name in the text field.")
    public void userEnterCustomerNameInTheTextField() {
        estimateEnquirySearchPage.enterCustomerNameTextbox(configLoader.getProperty("CustomerName"));

    }

    @Then("User click on save button in the order page.")
    public void userClickOnSaveButtonInTheOrderPage() {
        estimateEnquirySearchPage.ClickSaveBtn();

    }

    @Then("User verify the alert message and Click ok button.")
    public void userVerifyTheAlertMessageAndClickOkButton() {
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("NotificationMessage"));
        Assert.assertTrue(true);
    }

    @Then("User click on Add button in the add material popup.")
    public void userClickOnAddButtonInTheAddMaterialPopup() {
        orderSearchPage.waitFor();
        createOrderpage.clickCategory();
        orderSearchPage.waitFor();
        estimateEnquirySearchPage.clickAddBtn();
    }

    @Then("User Click on Edit icon in the Estimate Order Search Page.")
    public void userClickOnEditIconInTheEstimateOrderSearchPage() {
        estimateEnquirySearchPage.clickEditIcon();
        estimateEnquirySearchPage.waitFor();

    }

    @Then("User Click on Create Order Checkbox in Edit Estimate Order page.")
    public void userClickOnCreateOrderCheckboxInEditEstimateOrderPage() {
        estimateEnquirySearchPage.ClickCreateOrder();
    }

    @Then("User Click On Actions Dropdown and click on Create order option in the Edit Estimate Order Page.")
    public void userClickOnActionsDropdownAndClickOnCreateOrderOptionInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.clickCreateBtnInList();
    }

    @Then("User Click On Save Order Button in the Create Order Page.")
    public void userClickOnSaveOrderButtonInTheCreateOrderPage() {
        createOrderpage.SelectDropdownMake(configLoader.getProperty("Make"));
        estimateEnquirySearchPage.ClickSaveOrderBtn();
    }

    @Then("User Verifies an alert message and Click Ok button.")
    public void userVerifiesAnAlertMessageAndClickOkButton() {
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("NotificationMessage1"));
        Assert.assertTrue(true);

    }

    @Then("User enter part Number and click search button.")
    public void userEnterPartNumberAndClickSearchButton() {
        estimateEnquirySearchPage.EnterPartNum(configLoader.getProperty("PartNumber"));
    }

    @Then("User click on add button in add material popup.")
    public void userClickOnAddButtonInAddMaterialPopup() {
        estimateEnquirySearchPage.ClickAddButton7();
    }

    @Then("User click on save button in the add material .")
    public void userClickOnSaveButtonInTheAddMaterial() {
        estimateEnquirySearchPage.ClickSaveButton();
    }

    @Then("User click on save Order button in the order page.")
    public void userClickOnSaveOrderButtonInTheOrderPage() {
        estimateEnquirySearchPage.ClickSaveBtn();
    }

    @Then("User Select From Date and To Date in the Estimate Order Search.")
    public void userSelectFromDateAndToDateInTheEstimateOrderSearch() {
        estimateEnquirySearchPage.SelectFromDateAndToDate(configLoader.getProperty("FromDate"),
                configLoader.getProperty("ToDate"));
    }

    @Then("User click on Search button in the estimate order Search.")
    public void userClickOnSearchButtonInTheEstimateOrderSearch() {
        estimateEnquirySearchPage.ClickSearch();
    }

    @Then("User click on Plus icon in the edit estimate order page.")
    public void userClickOnPlusIconInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.ClickAdditionalItem();
    }

    @Then("User verifies the Items added alert message in the estimate order page.")
    public void userVerifiesTheItemsAddedAlertMessageInTheEstimateOrderPage() {
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("AddNotification"));
        Assert.assertTrue(true);
    }

    @Then("User Click on Update Checkbox in Edit Estimate Order page.")
    public void userClickOnUpdateCheckboxInEditEstimateOrderPage() {

        estimateEnquirySearchPage.ClickUpdateItem();
    }

    @Then("User Click On Actions Dropdown and click on save option in the Edit Estimate Order Page.")
    public void userClickOnActionsDropdownAndClickOnSaveOptionInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.clickSaveOptionInList();

    }

    @Then("User verifies the Items successfully added alert message in the estimate order page.")
    public void userVerifiesTheItemsSuccessfullyAddedAlertMessageInTheEstimateOrderPage() {
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("UpdateNotification"));
        Assert.assertTrue(true);
    }

    @Then("User selects Itemstatus from the dropdown in the edit estimate Order page.")
    public void userSelectsItemstatusFromTheDropdownInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.ClickUpdateItemStatus(configLoader.getProperty("updateItemStatus1"));

    }

    @Then("User selects Update Item status from update dropdown in the edit estimate order page.")
    public void userSelectsUpdateItemStatusFromUpdateDropdownInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.ClickDropdownMenu();
    }

    @Then("User verifies Update Item status alert message in the edit estimate order page.")
    public void userVerifiesUpdateItemStatusAlertMessageInTheEditEstimateOrderPage() {
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("UpdateItemNotification"));
        Assert.assertTrue(true);
    }

    @Then("User click on Actions dropdown and click send confirm notification to customer.")
    public void userClickOnActionsDropdownAndClickSendConfirmNotificationToCustomer() {
        estimateEnquirySearchPage.clickSaveOptionInList1();

    }

    @Then("User verifies the send notification alert message in the estimate order page.")
    public void userVerifiesTheSendNotificationAlertMessageInTheEstimateOrderPage() {
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("smsNotificaiton"));
        Assert.assertTrue(true);
    }

    @Then("User selects AssignTo from the dropdown in the edit estimate Order page.")
    public void userSelectsAssignToFromTheDropdownInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.ClickUpdateAssignTo(configLoader.getProperty("assignTo"));
    }

    @Then("User Click on AssignTo Checkbox in Edit Estimate Order page.")
    public void userClickOnAssignToCheckboxInEditEstimateOrderPage() {
        estimateEnquirySearchPage.UpdateAssignToCheckBox();
    }

    @Then("User selects Update AssignTo from update dropdown in the edit estimate order page.")
    public void userSelectsUpdateAssignToFromUpdateDropdownInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.ClickDropdownMenu1();
    }

    @Then("User verifies Update AssignTo alert message in the edit estimate order page.")
    public void userVerifiesUpdateAssignToAlertMessageInTheEditEstimateOrderPage() {
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("AssignNotification"));
        Assert.assertTrue(true);
    }

    @Then("User Click on Upload image icon.")
    public void userClickOnUploadImageIcon() {
        estimateEnquirySearchPage.ClickImageUpload();
    }

    @Then("User click on choose file button and click upload image button in the edit estimate order page..")
    public void userClickOnChooseFileButtonAndClickUploadImageButtonInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.CheckUploadImage();
    }

    @Then("User Click On Actions Dropdown and click on save option.")
    public void userClickOnActionsDropdownAndClickOnSaveOption() {
        estimateEnquirySearchPage.clickSaveOptionInList2();
    }

    @Then("User select items based on status in the estimate order search.")
    public void userSelectItemsBasedOnStatusInTheEstimateOrderSearch() {

        estimateEnquirySearchPage.SelectOrderStatus2(configLoader.getProperty("EstatusType2"));
        estimateEnquirySearchPage.ClickSearch();
        createOrderpage.waitFor();
        estimateEnquirySearchPage.SelectOrderStatus2(configLoader.getProperty("EstatusType3"));
        estimateEnquirySearchPage.ClickSearch();
        createOrderpage.waitFor();
        estimateEnquirySearchPage.SelectOrderStatus2(configLoader.getProperty("EstatusType4"));
        estimateEnquirySearchPage.ClickSearch();
        createOrderpage.waitFor();
        estimateEnquirySearchPage.SelectOrderStatus2(configLoader.getProperty("EstatusType5"));
        estimateEnquirySearchPage.ClickSearch();
        createOrderpage.waitFor();
        estimateEnquirySearchPage.SelectOrderStatus2(configLoader.getProperty("EstatusType6"));
        estimateEnquirySearchPage.ClickSearch();
        createOrderpage.waitFor();

    }

    @Then("User enter Enquiry number in the estimate order page.")
    public void userEnterEnquiryNumberInTheEstimateOrderPage() {
        estimateEnquirySearchPage.EnterInquiryNo(configLoader.getProperty("EstEnquiryNum"));
    }

    @Then("User enter ETA from the dropdown in the edit estimate Order page.")
    public void userEnterETAFromTheDropdownInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.EnterETADate(configLoader.getProperty("ETADate"));

    }

    @Then("User selects Update ETA from update dropdown in the edit estimate order page.")
    public void userSelectsUpdateETAFromUpdateDropdownInTheEditEstimateOrderPage() {
        estimateEnquirySearchPage.waitFor();
        estimateEnquirySearchPage.ClickDropdownMenu2();
    }

    @Then("User verifies Update ETA alert message in the edit estimate order page.")
    public void userVerifiesUpdateETAAlertMessageInTheEditEstimateOrderPage() {
        bulkUploadPage.verifyAlertMessage(configLoader.getProperty("ETANotification"));
        Assert.assertTrue(true);
    }

    @Then("User click on Estimate Enquiry search option.")
    public void userClickOnEstimateEnquirySearchOption() {
        estimateEnquirySearchPage.ClickEnquirySearch();

    }

    @Then("User click Insurance option.")
    public void userClickInsuranceOption() {
        estimateEnquirySearchPage.ClickInsuranceTab();
    }

    @Then("User enter Enquiry No in the Insurance Estimate Order page and click search Button.")
    public void userEnterEnquiryNoInTheInsuranceEstimateOrderPageAndClickSearchButton() {
        estimateEnquirySearchPage.SelectInsurance(configLoader.getProperty("IEnquiryNo"));
    }

    @Then("User click on Stock Details Button.")
    public void userClickOnStockDetailsButton() {
        estimateEnquirySearchPage.ClickStockDetails();
    }

    @Then("User verifies the details of products shown in nearest company Branch and click close icon.")
    public void userVerifiesTheDetailsOfProductsShownInNearestCompanyBranchAndClickCloseIcon() {
        Assert.assertEquals("Vendor Stock Details", estimateEnquirySearchPage.SelectBranch());

    }
}
