package scenarios.stepDefinitions.PartsOrder;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.PartsOrder.EstimateEnquiryDetailsPage;
import utilities.ConfigLoader;

public class EstimateEnquiryDetailsStepDef {

    public ConfigLoader configLoader;
    public TestContext testContext;
    public Scenario scenario;
    public EstimateEnquiryDetailsPage estimateEnquiryDetailsPage;

    public EstimateEnquiryDetailsStepDef(TestContext testContext) {
        this.estimateEnquiryDetailsPage = testContext.estimateEnquiryDetailsPage;
        this.scenario = testContext.scenario;
        this.testContext = testContext;
        this.configLoader = testContext.configLoader;
    }

    @Then("User click on Estimate Enquiry Details option.")
    public void userClickOnEstimateEnquiryDetailsOption() {
        estimateEnquiryDetailsPage.ClickPartsDropDown();
    }

    @Then("User select FromDate and ToDate in the Estimate inquiry page.")
    public void userSelectFromDateAndToDateInTheEstimateInquiryPage() {
        estimateEnquiryDetailsPage.SelectDates(configLoader.getProperty("Fdate"), configLoader.getProperty("Tdate"));
    }

    @Then("User select Confirmed Date from the dropdown list and click on search button.")
    public void userSelectConfirmedDateFromTheDropdownListAndClickOnSearchButton() {
        estimateEnquiryDetailsPage.SelectSearchBy(configLoader.getProperty("SearchBy1"));
    }

    @Then("User enter Inquiry number in the estimate Inquiry page and click search button.")
    public void userEnterInquiryNumberInTheEstimateInquiryPageAndClickSearchButton() {
        estimateEnquiryDetailsPage.EnterEnquiryNo(configLoader.getProperty("EstEnquiryNum"));
    }

    @Then("User click edit icon in the estimate Inquiry page.")
    public void userClickEditIconInTheEstimateInquiryPage() {
        estimateEnquiryDetailsPage.ClickEditIcon();
    }

    @Then("User enter quantity in add item details page.")
    public void userEnterQuantityInAddItemDetailsPage() {
        estimateEnquiryDetailsPage.EnterQuantity(configLoader.getProperty("EstQuan"));
    }

    @Then("User enter remarks and click on save button.")
    public void userEnterRemarksAndClickOnSaveButton() {
        estimateEnquiryDetailsPage.EnterRemarks(configLoader.getProperty("enterRemarks"));
    }

    @Then("User Verifies an edit item alert message and Click Ok button.")
    public void userVerifiesAnEditItemAlertMessageAndClickOkButton() {
        estimateEnquiryDetailsPage.verifyAlertMessage(configLoader.getProperty("UpdateItemNotification"));
        Assert.assertTrue(true);
    }

    @Then("User view items based on selection of status.")
    public void userViewItemsBasedOnSelectionOfStatus() {
        estimateEnquiryDetailsPage.SelectItemStatus(configLoader.getProperty("updateItemStatus1"));
    }

    @Then("User click on Insurance Tab Option.")
    public void userClickOnInsuranceTabOption() {
        estimateEnquiryDetailsPage.SelectInsurance();
    }

    @Then("User select FrDate and ToDate in the Estimate inquiry page.")
    public void userSelectFrDateAndToDateInTheEstimateInquiryPage() {
        estimateEnquiryDetailsPage.SelectFrDate(configLoader.getProperty("frDate1"),
                configLoader.getProperty("todate1"));
        estimateEnquiryDetailsPage.SelectSearchIns();
    }

    @Then("User view line item based on selection of status.")
    public void userViewLineItemBasedOnSelectionOfStatus() {
        estimateEnquiryDetailsPage.SelectStatusIns(configLoader.getProperty("updateItemStatus1"));
        estimateEnquiryDetailsPage.SelectSearchIns();

    }

    @Then("User select Confirmed Date From dropdown list in estimate enquiry insurance.")
    public void userSelectConfirmedDateFromDropdownListInEstimateEnquiryInsurance() {
        estimateEnquiryDetailsPage.SelectOrderStatus(configLoader.getProperty("SearchBy1"));
    }
}
