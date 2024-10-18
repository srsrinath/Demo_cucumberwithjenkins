package pages.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.CredsLoader;

public class CustomerPage extends BasePage {

    private final By icon = By.xpath("//img[@id='headermenuicon']");
    private final By customerDropdown = By.xpath("(//div[@class='row'])[2]/div[2]/h4/b");
    private final By customer = By.xpath("(//table[@class='tblaltclrmenuPanel'])[2]/tbody/tr[2]/th");
    private final By customerButton = By.id("addCustomerButton");
    private final By name = By.id("txtName");
    private final By customerCategory = By.id("custCatgListContainer");
    private final By kooversCategory = By.id("kCategory");
    private final By description = By.id("txtDescription");
    private final By customerContactNumber = By.id("txtContactNumber");
    private final By newKooversCategory = By.id("custType");
    private final By primaryServiceOffered = By.id("txtPrimaryService");
    private final By secondaryServiceOffered = By.id("txtSecondaryService");
    private final By gstIn = By.id("txtGstIn");
    private final By location = By.id("locationDLmain");
    private final By city = By.id("cityDLmain");
    private final By reg = By.id("txtregionmain");
    private final By rout = By.id("txtRoute");
    private final By cashLimit = By.id("txtCashLimit");
    private final By cashDays = By.id("txtCashDays");
    private final By emailId = By.id("txtEmail");
    private final By Status = By.id("status");
    private final By address = By.id("txtAddrLine1");
    private final By billingAddressLocation = By.id("txtLocation");
    private final By State = By.id("stateList");
    private final By pinCode = By.id("txtPinCode");
    private final By mobileNumber = By.id("txtMobileNumber");
    private final By crmExecutive = By.id("kEmpName");
    private final By creditLimit = By.id("txtCreditLimit");
    private final By creditDays = By.id("txtCreditDays");
    private final By shippingAddressCheckbox = By.id("addId");
    private final By saveButton = By.id("btnSave");
    private final By country = By.id("txtCountry");
    private final By vehicleSegment = By.id("evSegment");
    private final By contact = By.id("nav-contactsTab-tab");
    private final By contactIcon = By.id("btnAddContact");
    private final By firstName = By.id("txtFirstNamepop");
    private final By lastName = By.id("txtLastNamepop");
    private final By email = By.id("txtEmailpop");
    private final By telephone = By.id("txtTelephonepop");
    private final By mobNumber = By.id("txtMobliepop");
    private final By addButton = By.id("btnAdd");
    private final By cancelButton = By.id("btnCancel");
    private final By contactTitle = By.xpath("//td[text()=\"Contacts\"]");
    private final By contactDetailsTitle = By.xpath("//h3[text()=\"Contact Details\"]");
    private final By customerSearch = By.id("myInput");
    private String contactName = "//td[contains(text(),'%s')]";
    private final String Viewicon = "(//*[contains(text(),'%s')]/following-sibling::td//i)[1]";

    private final String changeIcon = "(//*[contains(text(),'%s')]/following-sibling::td//i)[2]";
    private final String deleteIcon = "(//*[contains(text(),'%s')]/following-sibling::td//i)[3]";
    private final By gstTab = By.id("nav-galleryTab-tab");
    private final By docType = By.id("docType");
    private final By imageFileButton = By.id("imagecatFileSelectPop");
    private final By uploadImageButton = By.xpath("(//input[@type='button'])[8]");
    private final By viewIcon = By.id("btnEye");
    public static final String randomCustomerNameM = getRandomName();
    public static final String contactNumberM = getMobileNumber();
    public static final String randomCustomerNameA = getRandomName();
    public static final String contactNumberA = getMobileNumber();
    public static final String GstInNumberA = generateRandomGSTIN();
    public static final String ranEmailA = getRandomEmail();

    public static String cnameM = null;
    public static String cnameA = null;
    public static String cGst = null;
    public static String cMobileA = null;
    public static String cMobileM = null;

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void HamburgerIcon() {
        clickOnElement(icon);

    }

    public void customerTab() {
        clickOnElement(customerDropdown);
        clickOnElement(customer);
    }

    public void customerBtn() {
        clickOnElement(customerButton);
    }

    public void enterMandatoryBasicDetails(String kCategory, String NkCategory, String City) {

        enterTextOnElement(name, randomCustomerNameM);
        selectFromDropDown(kooversCategory, kCategory);
        enterTextOnElement(customerContactNumber, contactNumberM);
        selectFromDropDown(newKooversCategory, NkCategory);
        selectFromDropDown(city, City);
        System.out.println("the customer name is " + randomCustomerNameM);
        cnameM = randomCustomerNameM;
    }

    public void enterMandatoryAddressDetails(String Address, String state, String pinCode, String vSegment,
            String status) {
        enterTextOnElement(address, Address);
        selectFromDropDown(State, state);
        enterTextOnElement(this.pinCode, pinCode);
        enterTextOnElement(mobileNumber, contactNumberM);
        selectFromDropDown(vehicleSegment, vSegment);
        selectFromDropDown(Status, status);
        cMobileM = contactNumberM;
        System.out.println(cMobileM);

    }

    public void enterMandatoryAddressDetails1(String Address, String state, String pinCode, String vSegment,
            String status) {
        enterTextOnElement(address, Address);
        selectFromDropDown(State, state);
        enterTextOnElement(this.pinCode, pinCode);
        selectFromDropDown(vehicleSegment, vSegment);
        selectFromDropDown(Status, status);

    }

    public void clickCheckbox() {
        clickOnElement(shippingAddressCheckbox);
    }

    public void clickContactButton() {
        clickOnElement(contact);
    }

    public boolean verifyContactButton() {
        waitUntilElementIsDisplayed(contact);
        return driver.findElement(contact).isDisplayed();
    }

    public void clickContactIcon() {
        clickOnElement(contactIcon);
    }

    public void enterContactMandatoryDetails(String newFirstName, String newMobile) {
        enterTextOnElement(firstName, newFirstName);
        enterTextOnElement(mobNumber, newMobile);

    }

    public void addButton() {
        clickOnElement(addButton);
    }

    public void ClickAccept() {
        driver.switchTo().alert().accept();
        waitFor();
    }

    public boolean verifySuccessAlertMessage(String text) {
        try {
            Thread.sleep(1000);
            System.out.println(text);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return verifyAlertMessage(text);
    }

    public boolean verifySuccessAlertMessage1(String text) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return verifyAlertMessage(text);
    }

    public boolean verifyContactTableTitle() {
        waitUntilElementIsDisplayed(contactTitle);
        return driver.findElement(contactTitle).isDisplayed();
    }

    public boolean verifyContactDetailsTitle() {
        waitUntilElementIsDisplayed(contactDetailsTitle);
        return driver.findElement(contactDetailsTitle).isDisplayed();
    }

    public boolean verifyContactName(String name) {
        boolean result = false;
        waitUntilElementIsDisplayed(By.xpath(dynamicLocators(contactName, name)));
        if (driver.findElement(By.xpath(dynamicLocators(contactName, name))).getText().equals(name)) {
            result = true;
        }
        return result;
    }

    public void clickSave() {
        clickOnElement(saveButton);
    }

    // all fields
    public void enterBasicDetails(String cCategory, String kCategory, String Description) {
        enterTextOnElement(name, randomCustomerNameA);
        selectFromDropDown(customerCategory, cCategory);
        selectFromDropDown(kooversCategory, kCategory);
        enterTextOnElement(description, Description);
        enterTextOnElement(customerContactNumber, contactNumberA);
        cnameA = randomCustomerNameA;

    }

    public void enterServicesDetails(String NKCategory, String PSOffered, String SSOffered) {
        selectFromDropDown(newKooversCategory, NKCategory);
        selectFromDropDown(primaryServiceOffered, PSOffered);
        selectFromDropDown(secondaryServiceOffered, SSOffered);
    }

    public void enterAddressDetails(String City, String Region, String Route, String CashOSandingLimit,
            String CashOStandingDays) {
        enterTextOnElement(gstIn, GstInNumberA);
        selectFromDropDown(city, City);
        selectFromDropDown(rout, Route);
        enterTextOnElement(cashLimit, CashOSandingLimit);
        enterTextOnElement(cashDays, CashOStandingDays);
        enterTextOnElement(emailId, ranEmailA);
        selectFromDropDown(reg, Region);
        cGst = GstInNumberA;
        System.out.println(cGst);
        enterTextOnElement(mobileNumber, contactNumberA);
        cMobileA = contactNumberA;
        System.out.println("the contact number entered in all fields:" + cMobileA);
    }

    public void enterCreditDetails(String CreditOStandingLimit, String CreditOStandingDays) {
        enterTextOnElement(creditLimit, CreditOStandingLimit);
        enterTextOnElement(creditDays, CreditOStandingDays);
    }

    public void enterContactDetails(String NFName, String LName, String TNumber, String NMobile) {
        enterTextOnElement(firstName, NFName);
        enterTextOnElement(lastName, LName);
        enterTextOnElement(email, ranEmailA);
        enterTextOnElement(telephone, TNumber);
        enterTextOnElement(mobNumber, NMobile);

    }

//customer inquiry screen-customer
    public void enterCustomerName() {
        enterTextOnElement(customerSearch, cnameM);
    }

    public void enteredCustomerName() {
        enterTextOnElement(customerSearch, cnameA);
    }

    public void clickViewIcon() throws InterruptedException {
        waitUntilElementIsDisplayed(By.xpath(dynamicLocators(Viewicon, cnameA)));
        clickOnElement(By.xpath(dynamicLocators(Viewicon, cnameA)));
        waitFor();
        System.out.println(getTextOnElement(By.id("allModalHeader")));
        clickElementById("deleteMaterial");

    }

    public void clickIconEdit() {
        System.out.println(CustomerPage.cnameM);
        waitUntilElementIsDisplayed(By.xpath(dynamicLocators(changeIcon, CustomerPage.cnameM)));
        clickOnElement(By.xpath(dynamicLocators(changeIcon, CustomerPage.cnameM)));
    }

    public void ClickGstTab() {
        clickOnElement(gstTab);
    }

    public void ClickDocTypeDropdown(String DocType) {
        selectFromDropDown(docType, DocType);
    }

    public void uploadImageFile() {
        driver.findElement(imageFileButton)
                .sendKeys(System.getProperty("user.dir") + new CredsLoader().getProperty("JPEG_IMAGE"));
        clickOnElement(uploadImageButton);
    }

    public void clickIcon() {
        clickOnElement(viewIcon);
    }

    public void clickDeleteIcon() {
        waitUntilElementIsDisplayed(By.xpath(dynamicLocators(deleteIcon, CustomerPage.cnameM)));
        clickOnElement(By.xpath(dynamicLocators(deleteIcon, CustomerPage.cnameM)));

    }

}
