package pages.PartsOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import scenarios.stepDefinitions.PartsOrder.OrderSearchStepDef;

import java.util.Set;

public class OrderSearchPage extends BasePage {

    public OrderSearchPage(WebDriver driver) {
        super(driver);
    }

    private final By partsOrderDropdown = By.xpath("(//div[@class='row'])[3]/div[2]/h4/b");
    private final By FromDate = By.id("searchDateFrom");
    private final By ToDate = By.id("searchDateTo");
    private final By assignTo = By.id("kEmpName");
    private final By ClickUpdateBtn = By.xpath("//a[@id='updateButton']");
    private final By SearchBar = By.id("myInput");
    private final String EditIcon = "(//*[contains(text(),'30259284')]/following-sibling::td//i)[1]";
    private final By addBtn = By.id("btnAdd_4596236");
    private final By addBtn1 = By.id("btnAdd_38705488");
    private final By SearchPartNumber = By.id("popproductCodeDl");
    private final By OrderSearch = By.xpath("((//table[@class='tblaltclrmenuPanel'])[3]/tbody/tr[2]/th)[1]");
    private final By searchIcon = By.xpath("(//span[@class='searchmobilebutton'])[2]");
    private final By InsuranceTab = By.id("nav-contactsTab-tab");
    private final By FromDate1 = By.id("searchDateFromins");
    private final By ToDate1 = By.id("searchDateToins");
    private final By ISearchBtn = By.id("searchins");
    private final By IconEdit = By.xpath("((//table[@id='myTable'])[2]/tbody/tr/td[position()>last()-4])[1]");
    private final By SelectStatus = By.id("status");
    private final By SelectText = By.xpath("(//table[@id='myTable']/tbody/tr/child::td[5])[1]");
    private final By SelectCancelled = By.xpath("//div[@class='dropdown-menu show']/a[4]");
    private final By EnterRemarksCan = By.id("txtCancelComments");
    private final By ClickSaveButton = By.id("txtOrderReasonStatus");
    private final By EnqNumber = By.id("inqnum1");
    private final By EnquiryNumber = By.xpath("((//table[@id='myTable'][1])[1]/tbody/tr[1]/td[position()=2])[1]");
    private final By SelectStatus1 = By.id("statusins");
    private final By ISelectText = By.xpath("((//table[@id='myTable'])[2]/tbody/tr/child::td[5])[1]");
    private final By IEnquiryNumber = By.id("inqnum1ins");
    private final By IEnqNumber = By.xpath("((//table[@id='myTable'])[2]/tbody/tr/td[position()=2])[1]");
    private final By ICancelled = By.xpath("(//div[@class='dropdown show']/div/a[position()>last()-2])[1]");
    private final By AddItem = By.xpath("//a[@id='addButton']");
    private final By RefreshIcon = By.id("headerrefreshimg");
    private final By backBtn = By.id("cancelButton");
    private final By NewOrderButton = By
            .xpath("//form[@id='salesreportinqform']/table/tbody/tr/td[position()>last()-1]");
    private final By SearchButton = By.id("search");
    private final By SelectCategory = By.xpath("(//div[normalize-space()='Front Brake Pads'])[1]");
    private final By RefreshList = By.xpath("//input[@id='headerrefreshimg']");
    private final By updateItemStatus = By.xpath("(//a[@id='dropdownMenuLink'])");
    private final By closeBtn = By.xpath("//i[@onclick=\"contactPopupClose()\"]");
    private final By SelectUpdateStatus = By
            .xpath("((//table[@id='myTable'][1])[1]/tbody/tr[1]/td[position() > last() - 3])[1]");
    private final By addBtn2 = By.id("btnAdd_55698948");
    private final By ClickEditIcon = By.xpath("(//table[@id='myTable']/tbody/tr/child::td[i])[1]");
    private final By OrderNumFromDate = By.id("searchDateFrom");
    private final By OrderNumToDate = By.id("searchDateTo");
    private final By OrderSearchBtn = By.xpath("//input[@id='search']");
    private final By SearchIcon1 = By.id("searchpaymentdetails");
    private final By VendorId = By.id("vendoridn");
    private final By InputCheckBox = By.xpath("(//input[@type='checkbox'])[1]");
    private final By PrintItem = By.xpath("//a[@id='printButton']");
    private final By InputCheckBox2 = By.xpath("(//input[@type='checkbox'])[2]");
    private final By StockButon = By.xpath("//input[@value='Stock Details']");
    private final By Headero = By.xpath("(//h3[@id='allModalHeader'])[8]");
    private final By SearchEnquiryNum = By.id("inqnum2ins");
    private final By SearchIns = By.id("searchins");
    private final By EnquirySearch = By.xpath("(//table[@class='tblaltclrmenuPanel'])[3]/tbody/tr[4]/th");
    private final By EditIcons = By.xpath("((//table[@id='myTable'])[2]/tbody/tr[1]/td[position() > last() - 3])[1]");
    private final By OverrideSave = By.id("overrideSaveBtnTr");
    private final By EnquirySearchs = By.id("inqnum1ins");
    private final By SearchIButton = By.xpath("//input[@id='searchins']");

    public void ClickEnquiry() {
        enterTextOnElement(EnquirySearchs, OrderSearchStepDef.SoNum);
        clickOnElement(SearchIButton);

    }

    public void ClickEditIcon() {
        clickOnElement(EditIcons);
    }

    public void SearchInput() {
        enterTextOnElement(SearchEnquiryNum, OrderSearchStepDef.SoNum);
        clickOnElement(SearchIns);
    }

    public void ClickSaveBtn() {
        clickOnElement(OverrideSave);
    }

    public String SelectBranch1() {

        String text1 = getTextOnElement(Headero);
        return text1;
    }

    public void clickStockButton() {
        clickOnElement(StockButon);
    }

    public void handleNewWindowAndGetText() {
        // Store the current window handle
        String originalWindow = driver.getWindowHandle();

        // Wait for the new window to open
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break; // Switch to the new window
            }
        }

        waitFor();
        String text = driver.findElement(By.xpath("//span/b[@id='vendorName']")).getText();
        System.out.println("the vendor Name is :" + text);
        // Close the new window
        driver.close();

        // Switch back to the original window
        driver.switchTo().window(originalWindow);
    }

    public void SelectVendorName(String val) {
        selectFromDropDown(VendorId, val);
    }

    public void ClickCheckbox() {
        clickOnElement(InputCheckBox);
    }

    public void ClickCheckboxes() {
        clickOnElement(InputCheckBox);
        clickOnElement(InputCheckBox2);
    }

    public void clickPrintOptionInList() {
        waitFor();
        Actions ay = new Actions(driver);
        WebElement category1 = driver.findElement(By.xpath("(//a[@id='dropdownMenuLink'])"));
        category1.click();
        waitFor();
        clickOnElement(PrintItem);
    }

    public void ClickSearchIcon() {
        clickOnElement(SearchIcon1);
    }

    public void EnterOrderNumberDates(String FrmDate, String ToDate) {
        datePicker(OrderNumFromDate, FrmDate);
        datePicker(OrderNumToDate, ToDate);
        clickOnElement(OrderSearchBtn);
    }

    public void EnterSearchData(String value) {
        enterTextOnElement(SearchBar, value);
    }

    public void clickEditIcon() {
        clickOnElement(ClickEditIcon);
        clickOnElement(RefreshList);

    }

    public void ClickEditIcon(String value) {
        waitUntilElementIsDisplayed(By.xpath(dynamicLocators(EditIcon, value)));
        clickOnElement(By.xpath(dynamicLocators(EditIcon, value)));

    }

    public void clickCategory() {
        Actions ag = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("(//div[normalize-space()='Front Brake Pads'])[1]"));
        ag.doubleClick(category).build().perform();
    }

    public void ClickAddBtn() {
        clickOnElement(addBtn);
    }

    public void ClickBtn() {
        clickOnElement(addBtn1);
    }

    public void EnterPartNumber(String value) {
        enterTextOnElement(SearchPartNumber, value);
        clickOnElement(searchIcon);
    }

    public void selectAssignTo(String value) {
        selectFromDropDown(assignTo, value);
    }

    public void clickUpdateOptionInList() {
        waitFor();
        Actions ag = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("(//a[@id='dropdownMenuLink'])"));
        waitUntilElementIsDisplayed(By.xpath("(//a[@id='dropdownMenuLink'])"));
        ag.doubleClick(category).build().perform();
        clickOnElement(ClickUpdateBtn);
    }

    public boolean SelectStatusText() {
        System.out
                .println("the selected " + getTextOnElement(SelectText) + "   " + "order status details are displayed");
        return true;
    }

    public boolean ISelectStatusText() {
        System.out.println(
                "the selected " + getTextOnElement(ISelectText) + "   " + "order status details are displayed");
        return true;
    }

    public void SelectOrderStatus(String val) {
        selectFromDropDown(SelectStatus, val);
    }

    public void SelectOrderStatus1(String val) {
        selectFromDropDown(SelectStatus1, val);
    }

    public void SelectUpdateStatus(String val2) {
        Actions ac = new Actions(driver);
        WebElement ele = driver
                .findElement(By.xpath("((//table[@id='myTable'][1])[1]/tbody/tr[10]/td[position() > last() - 3])[1]"));
        ac.doubleClick(ele).build().perform();
        clickOnElement(SelectCancelled);
        // clickOnElement(SelectUpdateStatus);
        // selectFromDropDown(SelectCancelled,val1);
        enterTextOnElement(EnterRemarksCan, val2);
        clickOnElement(ClickSaveButton);
    }

    public void SelectUpdateStatus1(String val2) {
        Actions ac = new Actions(driver);
        WebElement ele = driver
                .findElement(By.xpath("((//table[@id='myTable'])[2]/tbody/tr[1]/td[position() > last() - 3])[1]"));
        ac.doubleClick(ele).build().perform();
        clickOnElement(ICancelled);
        // clickOnElement(SelectUpdateStatus);
        // selectFromDropDown(SelectCancelled,val1);
        enterTextOnElement(EnterRemarksCan, val2);
        clickOnElement(ClickSaveButton);
    }

    public void ClickSearch() {
        clickOnElement(SearchButton);
    }

    public void EnterEnquiryNumber(String val) {
        enterTextOnElement(EnqNumber, val);
    }

    public void EnterEnquiryNumber1(String val) {
        enterTextOnElement(IEnquiryNumber, val);
    }

    public void SelectEnquiryNumber() {
        System.out.println(getTextOnElement(EnquiryNumber));
    }

    public void ClickInsuranceTab() {
        clickOnElement(InsuranceTab);
    }

    public void SelectFromDateAndToDate(String FDate, String TDate) {
        datePicker(FromDate1, FDate);
        datePicker(ToDate1, TDate);
    }

    public void SearchButton() {
        clickOnElement(ISearchBtn);
    }

    public void EditIconClick() {
        clickOnElement(IconEdit);
    }

    public void ISelectText() {
        System.out.println(getTextOnElement(IEnqNumber));
    }

    public void ClickOrderTab() {
        clickOnElement(partsOrderDropdown);
    }

    public void ClickPartsOrderTab() {
        clickOnElement(partsOrderDropdown);
        clickOnElement(OrderSearch);

    }

    public void ClickDropDown() {
        WebElement DropDown = driver.findElement(By.xpath("(//a[@id='dropdownMenuLink'])[1]"));
        Actions ac = new Actions(driver);
        ac.doubleClick(DropDown).build().perform();
        clickOnElement(AddItem);
    }

    public void ClickRefreshIcon() {

        clickOnElement(RefreshIcon);
    }
    // public void EnterSearchData(){
//        String orderNumber=CreateOrderStepDef.CommonItemsCreatedOrderNum;
//        enterTextOnElement(SearchBar,orderNumber);
//        waitFor();
//    }

    public void ClickEnquirySearchOption() {
        clickOnElement(EnquirySearch);
    }

    public void ClickBackBtn() {

        clickOnElement(backBtn);
    }

    public void ClickNewOrderButton() {

        clickOnElement(NewOrderButton);
    }

    public void clickAddBtn() {

        clickOnElement(addBtn2);
    }
}
