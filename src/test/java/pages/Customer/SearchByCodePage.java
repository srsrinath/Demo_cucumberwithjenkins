package pages.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import scenarios.stepDefinitions.Customer.CustomerStepDef;

public class SearchByCodePage extends BasePage {

    public SearchByCodePage(WebDriver driver) {
        super(driver);
    }

    private final By icon = By.xpath("//img[@id='headermenuicon']");
    private final By customerDropdown = By.xpath("(//div[@class='row'])[2]/div[2]/h4/b");
    private final By searchByCode = By.xpath("(//table[@class='tblaltclrmenuPanel'])[2]/tbody/tr[1]/th");
    private final By cusCode = By.id("customerCode");
    private final By cusName = By.id("customerName");
    private final By cusMobileNumber = By.id("mobileNo");
    private final By cusGstIn = By.id("gstin");
    private final By cusCity = By.id("cityDL");
    private final By cusSearch = By.id("search");
    private final By cusView = By.id("update-material");
    private final By cusDeActive = By.id("deact");

    public void ClickHamburgerIcon() {
        clickOnElement(icon);
        waitFor();

    }

    public void searchByCode() {
        clickOnElement(customerDropdown);
        waitFor();
        clickOnElement(searchByCode);
    }

    public void EnterCusCode() {
        String cCode = CustomerStepDef.customerCode;
        enterTextOnElement(cusCode, cCode);
        waitFor();
    }

    public void clickSearchBtn() {
        clickOnElement(cusSearch);
        waitFor();
    }

    public void enterCusName() {
        enterTextOnElement(cusName, CustomerPage.cnameA);
        waitFor();

    }

    public void enterCusGst() {
        enterTextOnElement(cusGstIn, CustomerPage.cGst);
        waitFor();
    }

    public void enterCusMobile() {
        enterTextOnElement(cusMobileNumber, CustomerPage.cMobileA);
        System.out.println("entered mobile number is " + CustomerPage.cMobileA);
    }

    public void clickViewIcon() {
//        //waitUntilElementIsDisplayed(By.xpath(dynamicLocators(cusView,CustomerPage.cname)));
//        clickOnElement(By.xpath(dynamicLocators(cusView,CustomerPage.cname)));
//        waitFor();
        clickOnElement(cusView);
        System.out.println(getTextOnElement(By.id("allModalHeader")));
        clickElementById("deleteMaterial");
    }

    public void enterCity() {
        String cCity = CustomerStepDef.customerCity;
        selectFromDropDown(cusCity, cCity);
    }

    public void clickDeAct() {
        clickOnElement(cusDeActive);
    }

}
