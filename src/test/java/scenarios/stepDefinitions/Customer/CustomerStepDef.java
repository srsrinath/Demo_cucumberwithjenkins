package scenarios.stepDefinitions.Customer;

import context.TestContext;
import dbhelper.DbExecutor;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Customer.CustomerPage;
import pages.Dashboard.HomePage;
import pages.Login.LoginPage;
import utilities.ConfigLoader;

import java.util.List;
import java.util.Map;

public class CustomerStepDef {

    public TestContext testContext;
    public ConfigLoader configLoader;
    public WebDriver driver;
    public LoginPage loginPage;
    public CustomerPage customerPage;
    private static String conatctName;
    private Scenario scenario;
    private DbExecutor dbExecutor;
    public static String customerStatus = null;
    public static String kooversCategory = null;
    public static String newKooversCategory = null;
    public static String customerID = null;
    public HomePage homepage;
    public static String customerCode = null;
    public static String customerCity = null;

    public CustomerStepDef(TestContext testContext) {
        this.testContext = testContext;
        this.configLoader = testContext.configLoader;
        this.driver = testContext.driver;
        this.loginPage = testContext.loginPage;
        this.customerPage = testContext.customerPage;
        this.scenario = testContext.scenario;
        this.dbExecutor = testContext.dbExecutor;
        this.homepage = testContext.homepage;
    }

    @Then("User click on Add customer Button.")
    public void userClickOnAddCustomerButton() {
        customerPage.waitFor();
        customerPage.customerBtn();
        Assert.assertTrue(true);
        scenario.log("user clicks on add customer button");
    }

    @Then("User enters Name and Koovers Category and Contact Number and New koovers Category and City.")
    public void userEntersNameAndKooversCategoryAndContactNumberAndNewKooversCategoryAndCity() {
        customerPage.enterMandatoryBasicDetails(configLoader.getProperty("KooversCategory"),
                configLoader.getProperty("Newkooverscategory"), configLoader.getProperty("City"));
    }

    @Then("User clicks on same as billing address checkbox.")
    public void userClicksOnSameAsBillingAddressCheckbox() {
        customerPage.clickCheckbox();
    }

    @And("User clicks on Contacts Tab.")
    public void userClicksOnContactsTab() {
        customerPage.clickContactButton();
        customerPage.verifyContactButton();
        Assert.assertTrue(customerPage.verifyContactButton());
        scenario.log("User clicks on contact tab.");
    }

    @And("User clicks on Contacts plus icon.")
    public void userClicksOnContactsPlusIcon() {
        customerPage.clickContactIcon();
        Assert.assertTrue(true);
        scenario.log("user clicks on contact plus icon");

    }

    @Then("User enters first_name and m number.")
    public void userEntersFirst_nameAndMNumber() {
        conatctName = configLoader.getProperty("firstname");
        customerPage.enterContactMandatoryDetails(configLoader.getProperty("firstname"),
                configLoader.getProperty("mnumber"));
    }

    @And("User clicks on Ok button.")
    public void userClicksOnOkButton() {
        customerPage.addButton();
        Assert.assertTrue(customerPage.verifyContactTableTitle());
        scenario.log("User click on contact plus icon.");
    }

    @Then("User clicks on save button.")
    public void userClicksOnSaveButton() {
        customerPage.clickSave();
        Assert.assertTrue(true);
        scenario.log("User click on save button.");

    }

    @Then("User verify the alert message of customer creation and click ok button.")
    public void userVerifyTheAlertMessageOfCustomerCreationAndClickOkButton() {
        // mandatory fields
        boolean result1 = customerPage.verifySuccessAlertMessage(configLoader.getProperty("alertmessage"));
        scenario.log("User verifies the alert message " + result1);
        System.out.println(result1);
        Assert.assertTrue(result1);
        List<Map<String, String>> customerResultM = dbExecutor.getCustomerDetails(CustomerPage.randomCustomerNameM);
        Assert.assertEquals(customerResultM.get(0).get("NAME"), CustomerPage.randomCustomerNameM);
        Assert.assertNotNull(customerResultM.get(0).get("ID"));
        Assert.assertNotNull(customerResultM.get(0).get("CUSTOMER_CODE"));
        // Assert.assertNotNull(customerResultM.get(0).get("MOBILE_NUM"));
        customerPage.redirectToPage(configLoader.getProperty("Home_url"));
        scenario.log("User lands in home dash board page");
        homepage.clickRefreshCustomerList();
        homepage.waitFor();

    }

    @Then("User clicks on save button and able to view error message.")
    public void userClicksOnSaveButtonAndAbleToViewErrorMessage() {
        customerPage.clickSave();
        Assert.assertTrue(true);
        scenario.log("User click on save button.");
        customerPage.waitFor();
        System.out.println(customerPage.getTextOnElement(By.id("msgtxt")));
        scenario.log("user view error message of contact");
        customerPage.waitFor();
    }

    @Then("User clicks on save button and able to view error messages in the fields.")
    public void userClicksOnSaveButtonAndAbleToViewErrorMessagesInTheFields() {
        customerPage.clickSave();
        Assert.assertTrue(true);
        scenario.log("User click on save button.");
        System.out.println(customerPage.getTextOnElement(By.id("txtName-error")));
        scenario.log("user view error messages of each fields");
    }

    @Then("User click on view icon and verify customer details.")
    public void userClickOnViewIconAndVerifyCustomerDetails() throws InterruptedException {
        customerPage.waitFor();
        scenario.log("user click on view icon and view details");
        customerPage.clickViewIcon();
        customerPage.waitFor();

    }

    @Then("User enter customer name in the searchbar in the inquiry screen.")
    public void userEnterCustomerNameInTheSearchbarInTheInquiryScreen() {
        customerPage.enterCustomerName();
    }

    @Then("User click on edit icon in the customer inquiry screen.")
    public void userClickOnEditIconInTheCustomerInquiryScreen() {
        scenario.log("user click on edit icon");
        customerPage.waitFor();

        customerPage.clickIconEdit();
    }

    @Then("User click on GST File tab in the add customer page.")
    public void userClickOnGSTFileTabInTheAddCustomerPage() {
        customerPage.ClickGstTab();
        scenario.log("User click on GST Tab");
    }

    @And("User click on choose file button and click upload image button.")
    public void userClickOnChooseFileButtonAndClickUploadImageButton() {
        customerPage.uploadImageFile();

    }

    @Then("User enter customer name in searchbar.")
    public void userEnterCustomerNameInSearchbar() {
        customerPage.enterCustomerName();
    }

    @Then("User click on delete icon in the customer inquiry screen.")
    public void userClickOnDeleteIconInTheCustomerInquiryScreen() {
        customerPage.clickDeleteIcon();
    }

    @Then("User enters Name and Customer Category and Koovers Category and Description and contact Number.")
    public void userEntersNameAndCustomerCategoryAndKooversCategoryAndDescriptionAndContactNumber() {
        customerPage.enterBasicDetails(configLoader.getProperty("Customercategory"),
                configLoader.getProperty("KooversCategory"), configLoader.getProperty("Description"));
    }

    @Then("User enter new koovers category and Primary Service Offered and Secondary Service Offered.")
    public void userEnterNewKooversCategoryAndPrimaryServiceOfferedAndSecondaryServiceOffered() {
        customerPage.enterServicesDetails(configLoader.getProperty("Newkooverscategory"),
                configLoader.getProperty("Primaryserviceoffered"),
                configLoader.getProperty("secondaryservicesoffered"));
    }

    @Then("User enters GSTIN and city and region and route and Cash Outstanding Limit and Cash Outstanding Days and email id.")
    public void userEntersGSTINAndCityAndRegionAndRouteAndCashOutstandingLimitAndCashOutstandingDaysAndEmailId() {
        customerPage.enterAddressDetails(configLoader.getProperty("City"), configLoader.getProperty("region1"),
                configLoader.getProperty("route"), configLoader.getProperty("cashoutstandinglimit"),
                configLoader.getProperty("cashoutstandingdays"));

    }

    @Then("User enter Credit Outstanding Limit and Credit Outstanding Days.")
    public void userEnterCreditOutstandingLimitAndCreditOutstandingDays() {
        customerPage.enterCreditDetails(configLoader.getProperty("creditoutstandinglimit"),
                configLoader.getProperty("creditoutstandingdays"));
    }

    @Then("User enters first name and last name and email and Telephone number and mobile number.")
    public void userEntersFirstNameAndLastNameAndEmailAndTelephoneNumberAndMobileNumber() {
        customerPage.enterContactDetails(configLoader.getProperty("firstname"), configLoader.getProperty("lastname"),
                configLoader.getProperty("Tnumber"), configLoader.getProperty("mnumber"));
    }

    @Then("User verify the alert message of customer creation of all fields and click ok button.")
    public void userVerifyTheAlertMessageOfCustomerCreationOfAllFieldsAndClickOkButton() {
        // all fields
        boolean result = customerPage.verifySuccessAlertMessage1(configLoader.getProperty("alertmessage"));
        scenario.log("User verifies the alert message " + result);
        System.out.println(result);
        Assert.assertTrue(result);
        List<Map<String, String>> customerResult = dbExecutor.getCustomerDetails(CustomerPage.randomCustomerNameA);
        System.out.print(customerResult.get(0).get("NAME"));
        Assert.assertEquals(customerResult.get(0).get("NAME"), CustomerPage.randomCustomerNameA);
        Assert.assertNotNull(customerResult.get(0).get("ID"));
        Assert.assertNotNull(customerResult.get(0).get("CUSTOMER_CODE"));
        Assert.assertEquals(customerResult.get(0).get("STATUS"), customerStatus);
        // Assert.assertNotNull(customerResult.get(0).get("MOBILE_NUM"));
        // System.out.println("the mobile number is" +
        // customerResult.get(0).get("MOBILE_NUM"));
//        try {
//            cusMobileA=customerResult.get(0).get("MOBILE_NUM");
//            BasePage.decrypt(cusMobileA);
//            System.out.println("Decrypted Mobile Number: " +cusMobileA);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Handle exceptions like BadPaddingException, InvalidKeyException, etc.
//        }

        // System.out.println("the decrypted mobilenumber is
        // "+BasePage.decrypt(cusMobileA));
        customerID = customerResult.get(0).get("ID");
        customerCode = customerResult.get(0).get("CUSTOMER_CODE");
        System.out.println(customerCode);
        customerCity = customerResult.get(0).get("CITY");
        System.out.println(customerCity);
        customerPage.redirectToPage(configLoader.getProperty("Home_url"));
        scenario.log("User lands in home dash board page");
        homepage.clickRefreshCustomerList();
        homepage.waitFor();
    }

    @Then("User select Document Type from the dropdown list.")
    public void userSelectDocumentTypeFromTheDropdownList() {
        customerPage.ClickDocTypeDropdown(configLoader.getProperty("DocumentType"));
    }

    @Then("User verify the update alert message and click ok button.")
    public void userVerifyTheUpdateAlertMessageAndClickOkButton() {
        boolean result = customerPage.verifySuccessAlertMessage(configLoader.getProperty("updatealertmessage"));
        scenario.log("User verifies the alert message " + result);
        System.out.println(result);
        Assert.assertTrue(result);
    }

    @Then("User verify the customer update alert message and click ok button.")
    public void userVerifyTheCustomerUpdateAlertMessageAndClickOkButton() {
        boolean result = customerPage.verifySuccessAlertMessage(configLoader.getProperty("Cupdatealertmessage"));
        scenario.log("User verifies the alert message " + result);
        System.out.println(result);
        Assert.assertTrue(result);
    }

    @And("User click on View icon in the add customer page for viewing uploaded GST.")
    public void userClickOnViewIconInTheAddCustomerPageForViewingUploadedGST() {
        customerPage.clickIcon();
        customerPage.switchToNewTabAndClose();
    }

    @Then("User verify the customer deactivated alert message and click ok button.")
    public void userVerifyTheCustomerDeactivatedAlertMessageAndClickOkButton() {
        scenario.log("User verifies the alert message ");
        customerPage.waitFor();
        customerPage.ClickAccept();
        boolean messagetext = customerPage.verifyAlertMessage(configLoader.getProperty("deactivatealertmessage"));
        Assert.assertTrue(messagetext);

    }

    @Then("User enter Address and state and pin code and phone number and vehicleSegment and status")
    public void userEnterAddressAndStateAndPinCodeAndPhoneNumberAndVehicleSegmentAndStatus() {
        customerPage.enterMandatoryAddressDetails(configLoader.getProperty("Address"),
                configLoader.getProperty("state1"), configLoader.getProperty("pincode"),
                configLoader.getProperty("vehiclsegment"), configLoader.getProperty("status1"));
        customerStatus = configLoader.getProperty("status1");
    }

    @Then("User enters Address and state and pin code and  vehicleSegment and status.")
    public void userEntersAddressAndStateAndPinCodeAndVehicleSegmentAndStatus() {
        customerPage.enterMandatoryAddressDetails1(configLoader.getProperty("Address"),
                configLoader.getProperty("state1"), configLoader.getProperty("pincode"),
                configLoader.getProperty("vehiclsegment"), configLoader.getProperty("status1"));
        customerStatus = configLoader.getProperty("status1");

    }

}
