package scenarios.stepDefinitions.PartsOrder;

import api.applicationApi.InsuranceSalesOrderApi;
import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Customer.CustomerPage;
import pages.PartsOrder.BulkUploadPage;
import pages.PartsOrder.CreateOrderPage;
import pages.PartsOrder.OrderSearchPage;
import pojo.List;
import utilities.ConfigLoader;

public class OrderSearchStepDef {

    public ConfigLoader configLoader;
    public TestContext testContext;
    public CreateOrderPage createOrderpage;
    public BulkUploadPage bulkUploadPage;
    public OrderSearchPage orderSearchPage;
    public CustomerPage customerPage;
    public Scenario scenario;
    public static String SoNum = null;

    public OrderSearchStepDef(TestContext testContext) {
        this.scenario = testContext.scenario;
        this.configLoader = testContext.configLoader;
        this.testContext = testContext;
        this.customerPage = testContext.customerPage;
        this.createOrderpage = testContext.createOrderpage;
        this.bulkUploadPage = testContext.bulkUploadPage;
        this.orderSearchPage = testContext.orderSearchPage;
    }

    @When("User click on PartOrder option.")
    public void userClickOnPartOrderOption() {
        bulkUploadPage.waitFor();
        bulkUploadPage.PartsOrderTab();
        bulkUploadPage.waitFor();

    }

    @Then("User click on Order search Option.")
    public void userClickOnOrderSearchOption() {
        bulkUploadPage.waitFor();
        bulkUploadPage.PartsOrderTab();
        bulkUploadPage.waitFor();
        orderSearchPage.ClickPartsOrderTab();
        createOrderpage.verifyTitle(configLoader.getProperty("title"));
    }

    @Then("User Select from Date and To Date in the Estimate Order Search.")
    public void userSelectFromDateAndToDateInTheEstimateOrderSearch() {
        orderSearchPage.SelectFromDateAndToDate(configLoader.getProperty("fromDate"),
                configLoader.getProperty("toDate"));

    }

    @Then("User click on Search button in the order Inquiry page.")
    public void userClickOnSearchButtonInTheOrderInquiryPage() {

        orderSearchPage.ClickSearch();
    }

    @Then("User Click on Edit icon in the Order Search Page.")
    public void userClickOnEditIconInTheOrderSearchPage() {

        orderSearchPage.clickEditIcon();
    }

    @Then("User select Assign To from DropdownList.")
    public void userSelectAssignToFromDropdownList() {
        orderSearchPage.selectAssignTo(configLoader.getProperty("AssignTo"));
    }

    @Then("User Click On Actions Dropdown and click on Update option in the update order details page.")
    public void userClickOnActionsDropdownAndClickOnUpdateOptionInTheUpdateOrderDetailsPage() {
        orderSearchPage.clickUpdateOptionInList();
        createOrderpage.waitFor();
    }

    @Then("User verifies the update alert message and click ok button.")
    public void userVerifiesTheUpdateAlertMessageAndClickOkButton() {
        createOrderpage.waitFor();
        createOrderpage.verifyAlertMessage(configLoader.getProperty("UpdateNotificationMessage"));
        Assert.assertEquals("Order details updated successfully",
                configLoader.getProperty("UpdateNotificationMessage"));
    }

    @Then("User click on RefreshIcon in the Order search Page.")
    public void userClickOnRefreshIconInTheOrderSearchPage() {

        orderSearchPage.ClickRefreshIcon();
    }

    @Then("User enter OrderNumber in the searchBar.")
    public void userEnterOrderNumberInTheSearchBar() {
        orderSearchPage.EnterOrderNumberDates(configLoader.getProperty("OrderNumberFromdate"),
                configLoader.getProperty("OrderNumberToDate"));
        orderSearchPage.EnterSearchData(configLoader.getProperty("ordernum"));

    }

    @Then("User click on Edit icon in the list.")
    public void userClickOnEditIconInTheList() {
        orderSearchPage.ClickEditIcon(configLoader.getProperty("ordernum"));
    }

    @Then("User click on add item option in actions dropdown list.")
    public void userClickOnAddItemOptionInActionsDropdownList() {
        orderSearchPage.ClickDropDown();
    }

    @Then("User click on add button in the add material popup")
    public void userClickOnAddButtonInTheAddMaterialPopup() {
        orderSearchPage.clickCategory();
        orderSearchPage.ClickAddBtn();
    }

    @Then("User clicks on Back Button in Update order page.")
    public void userClicksOnBackButtonInUpdateOrderPage() {

        orderSearchPage.ClickBackBtn();
    }

    @Then("User click on add button in  add material popup page.")
    public void userClickOnAddButtonInAddMaterialPopupPage() {
        orderSearchPage.clickCategory();
        orderSearchPage.ClickBtn();
    }

    @Then("User enter partnumber and click search button.")
    public void userEnterPartnumberAndClickSearchButton() {
        orderSearchPage.EnterPartNumber(configLoader.getProperty("PartNumber"));
        orderSearchPage.clickAddBtn();
    }

    @Then("User enter enquiryNo Morethan twnety characters in the Create order page.")
    public void userEnterEnquiryNoMorethanTwnetyCharactersInTheCreateOrderPage() {
        createOrderpage.waitFor();
        createOrderpage.ClickSearchIcon(configLoader.getProperty("Numbers"));

    }

    @Then("User Verify the errormessage in the create order page.")
    public void userVerifyTheErrormessageInTheCreateOrderPage() {
        Assert.assertEquals(createOrderpage.OrderErrorMessage(), configLoader.getProperty("OrderErrorMessage"));
        System.out.println(createOrderpage.OrderErrorMessage());
    }

    @Then("User select name from the auto suggestions.")
    public void userSelectNameFromTheAutoSuggestions() {
        createOrderpage.enterNameTextbox(configLoader.getProperty("customerName"));

    }

    @Then("User click on Payment Details Button.")
    public void userClickOnPaymentDetailsButton() {
        createOrderpage.clickPaymentButton();

    }

    @Then("User verify the paymentType and no.of days and limit and outstanding amount of particular customer.")
    public void userVerifyThePaymentTypeAndNoOfDaysAndLimitAndOutstandingAmountOfParticularCustomer() {
        Assert.assertTrue(createOrderpage.getPaymentDetails1());
        createOrderpage.ClickCloseIcon();
    }

    @Then("User click on Plus icon in the Create Order page.")
    public void userClickOnPlusIconInTheCreateOrderPage() {
        createOrderpage.ClickPlusButton();
    }

    @Then("User verifies the alert message {string} and click ok button.")
    public void userVerifiesTheAlertMessageAndClickOkButton(String text) {
        boolean result1 = customerPage.verifySuccessAlertMessage(text);
        scenario.log("User verifies the alert message " + text);
        System.out.println(result1);
        Assert.assertTrue(result1);
    }

    @Then("User clicks on Insurance Tab option.")
    public void userClicksOnInsuranceTabOption() {

        orderSearchPage.waitFor();

        orderSearchPage.ClickInsuranceTab();

    }

    @Then("User Selects the  fromDate and toDate in the EstimateOrder Search.")
    public void userSelectsTheFromDateAndToDateInTheEstimateOrderSearch() {
        orderSearchPage.SelectFromDateAndToDate(configLoader.getProperty("Fromdate"),
                configLoader.getProperty("Todate"));
        orderSearchPage.SearchButton();

    }

    @Then("User click  Search button in the order Inquiry page.")
    public void userClickSearchButtonInTheOrderInquiryPage() {

        orderSearchPage.SearchButton();
    }

    @Then("User Click on Edit icon in the Order Inquiry Page.")
    public void userClickOnEditIconInTheOrderInquiryPage() {

        orderSearchPage.EditIconClick();
    }

    @Then("User view order details based on selected status.")
    public void userViewOrderDetailsBasedOnSelectedStatus() {
        orderSearchPage.SelectOrderStatus(configLoader.getProperty("StatusType1"));
        orderSearchPage.ClickSearch();
        orderSearchPage.waitFor();
        boolean text1 = orderSearchPage.SelectStatusText();
        orderSearchPage.SelectOrderStatus(configLoader.getProperty("StatusType2"));
        orderSearchPage.ClickSearch();
        orderSearchPage.waitFor();
        boolean text2 = orderSearchPage.SelectStatusText();
        orderSearchPage.SelectOrderStatus(configLoader.getProperty("StatusType3"));
        orderSearchPage.ClickSearch();
        orderSearchPage.waitFor();
        boolean text3 = orderSearchPage.SelectStatusText();
        Assert.assertTrue(text1);
        Assert.assertTrue(text2);
        Assert.assertTrue(text3);

    }

    @Then("User select the Update status to cancelled and enter remarks.")
    public void userSelectTheUpdateStatusToCancelledAndEnterRemarks() {
        orderSearchPage.waitFor();
        orderSearchPage.SelectOrderStatus(configLoader.getProperty("StatusType4"));
        orderSearchPage.ClickSearch();
        orderSearchPage.waitFor();
        orderSearchPage.SelectUpdateStatus(configLoader.getProperty("RemarksText"));
    }

    @Then("User enter enquiryNumber and click search Button.")
    public void userEnterEnquiryNumberAndClickSearchButton() {
        orderSearchPage.EnterEnquiryNumber(configLoader.getProperty("EnquriyNumber"));
        orderSearchPage.ClickSearch();
        orderSearchPage.SelectEnquiryNumber();
    }

    @Then("User clicks on New Order Button in order inquiry page.")
    public void userClicksOnNewOrderButtonInOrderInquiryPage() {

        orderSearchPage.ClickNewOrderButton();
    }

    @Then("User view order details based on select status.")
    public void userViewOrderDetailsBasedOnSelectStatus() {
        orderSearchPage.SelectOrderStatus1(configLoader.getProperty("StatusType1"));
        orderSearchPage.SearchButton();
        orderSearchPage.waitFor();
        boolean text1 = orderSearchPage.ISelectStatusText();
        orderSearchPage.SelectOrderStatus1(configLoader.getProperty("StatusType3"));
        orderSearchPage.SearchButton();
        orderSearchPage.waitFor();
        boolean text3 = orderSearchPage.ISelectStatusText();
        Assert.assertTrue(text1);
        Assert.assertTrue(text3);
    }

    @Then("User enters enquiry Number and click search Button in the order inquiry page.")
    public void userEntersEnquiryNumberAndClickSearchButtonInTheOrderInquiryPage() {
        orderSearchPage.EnterEnquiryNumber1(configLoader.getProperty("IEnquirynumber"));
        orderSearchPage.SearchButton();
        orderSearchPage.ISelectText();
    }

    @Then("User select the Update status is cancelled and enter remarks.")
    public void userSelectTheUpdateStatusIsCancelledAndEnterRemarks() {
        orderSearchPage.waitFor();
        orderSearchPage.SelectOrderStatus1(configLoader.getProperty("StatusType4"));
        orderSearchPage.SearchButton();
        orderSearchPage.waitFor();
        orderSearchPage.SelectUpdateStatus1(configLoader.getProperty("RemarksText"));

    }

    @Then("User click on Search icon.")
    public void userClickOnSearchIcon() {
        orderSearchPage.ClickSearchIcon();
    }

    @Then("User Select fromDate and ToDate in Estimate Order Search")
    public void userSelectFromDateAndToDateInEstimateOrderSearch() {
        orderSearchPage.EnterOrderNumberDates(configLoader.getProperty("fromDate"), configLoader.getProperty("toDate"));
    }

    @Then("User enter vendor name in update order details.")
    public void userEnterVendorNameInUpdateOrderDetails() {
        orderSearchPage.SelectVendorName(configLoader.getProperty("vendorname"));
    }

    @Then("User click on one item checkbox in the list.")
    public void userClickOnOneItemCheckboxInTheList() {
        orderSearchPage.ClickCheckbox();
    }

    @Then("User click on print icon in the action dropdown list.")
    public void userClickOnPrintIconInTheActionDropdownList() {
        orderSearchPage.clickPrintOptionInList();
    }

    @Then("User verifies the order details present in the page.")
    public void userVerifiesTheOrderDetailsPresentInThePage() {
        orderSearchPage.handleNewWindowAndGetText();
    }

    @Then("User click on second item checkbox in the list.")
    public void userClickOnSecondItemCheckboxInTheList() {
        orderSearchPage.ClickCheckboxes();
    }

    @Then("User enter vendor Name in the update order details page.")
    public void userEnterVendorNameInTheUpdateOrderDetailsPage() {
        orderSearchPage.SelectVendorName(configLoader.getProperty("vendorname1"));
    }

    @Then("User click on stock availability button.")
    public void userClickOnStockAvailabilityButton() {
        orderSearchPage.clickStockButton();
    }

    @Then("User verifies the details of products shown  nearest company Branch and click close icon.")
    public void userVerifiesTheDetailsOfProductsShownNearestCompanyBranchAndClickCloseIcon() {
        Assert.assertEquals("Vendor Stock Details", orderSearchPage.SelectBranch1());

    }

    @Then("User click on enter enquiry number in the search bar in insurance estimate order search.")
    public void userClickOnEnterEnquiryNumberInTheSearchBarInInsuranceEstimateOrderSearch() {
        SoNum = new InsuranceSalesOrderApi().createSalesOrder().get("salesNo");
        System.out.println("the sales order Number is :" + SoNum);
        orderSearchPage.waitFor();
        orderSearchPage.SearchInput();

    }

    @When("User click on Orders  Option.")
    public void userClickOnOrdersOption() {
        bulkUploadPage.PartsOrderTab();
        bulkUploadPage.waitFor();
        orderSearchPage.ClickOrderTab();
    }

    @Then("User click on Estimate Enquiry search option page.")
    public void userClickOnEstimateEnquirySearchOptionPage() {
        orderSearchPage.ClickEnquirySearchOption();

    }

    @Then("User click the edit icon in the page.")
    public void userClickTheEditIconInThePage() {
        orderSearchPage.ClickEditIcon();
    }

    @Then("User click Override and save order button.")
    public void userClickOverrideAndSaveOrderButton() {
        orderSearchPage.ClickSaveBtn();
    }

    @Then("User enter enquiry Number and click search Button in the order inquiry page.")
    public void userEnterEnquiryNumberAndClickSearchButtonInTheOrderInquiryPage() {
        orderSearchPage.ClickEnquiry();
    }
}
