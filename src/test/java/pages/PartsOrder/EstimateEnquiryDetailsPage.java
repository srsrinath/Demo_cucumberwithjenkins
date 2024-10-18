package pages.PartsOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class EstimateEnquiryDetailsPage extends BasePage {

    public EstimateEnquiryDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By PartsTabDrop = By.xpath("(//div[@class='row'])[3]/div[2]/h4/b");
    private final By EnquiryDetails = By.xpath("(//table[@class='tblaltclrmenuPanel'])[3]/tbody/tr[3]/th");
    private final By SelectFrDate = By.id("searchDateFrom");
    private final By SelectToDate = By.id("searchDateTo");
    private final By SearchEs = By.xpath("//input[@id='search']");
    private final By SelectBy = By.id("srchBy");
    private final By EnquiryNo = By.id("enqnum");
    private final By EditIcon = By.xpath("(//table[@id='myTable']/tbody/tr/td[position()=2])[1]");
    private final By EnterQuan = By.id("txtOrderQnty");
    private final By EnterRemarks = By.id("txtDescription");
    private final By SaveBtn = By.xpath("//input[@id='btnAdd']");
    private final By StatusItem = By.id("itemStatus");
    private final By FrDate = By.id("searchDateFromins");
    private final By ToDate = By.id("searchDateToins");
    private final By SearchIns = By.id("searchins");
    private final By selectIns = By.id("itemStatusins");
    private final By selectInsOrder = By.id("srchByins");
    private final By selecInsurance = By.id("nav-contactsTab-tab");

    public void SelectInsurance() {
        clickOnElement(selecInsurance);
    }

    public void SelectFrDate(String val1, String val2) {
        datePicker(FrDate, val1);
        datePicker(ToDate, val2);
    }

    public void SelectSearchIns() {
        clickOnElement(SearchIns);
    }

    public void SelectStatusIns(String val) {
        selectFromDropDown(selectIns, val);
    }

    public void SelectOrderStatus(String val) {
        selectFromDropDown(selectInsOrder, val);
        clickOnElement(SearchIns);
    }

    public void ClickPartsDropDown() {
        waitFor();
        clickOnElement(PartsTabDrop);
        waitFor();
        clickOnElement(EnquiryDetails);
    }

    public void SelectDates(String val1, String val2) {
        datePicker(SelectFrDate, val1);
        datePicker(SelectToDate, val2);
        clickOnElement(SearchEs);
        waitFor();
    }

    public void SelectSearchBy(String val) {
        selectFromDropDown(SelectBy, val);
        clickOnElement(SearchEs);
    }

    public void EnterEnquiryNo(String val) {
        enterTextOnElement(EnquiryNo, val);
        clickOnElement(SearchEs);
    }

    public void ClickEditIcon() {
        clickOnElement(EditIcon);
    }

    public void EnterQuantity(String val) {
        enterTextOnElement(EnterQuan, val);
    }

    public void EnterRemarks(String val) {
        enterTextOnElement(EnterRemarks, val);
        clickOnElement(SaveBtn);
    }

    public void SelectItemStatus(String val) {
        selectFromDropDown(StatusItem, val);
        clickOnElement(SearchEs);
    }
}
