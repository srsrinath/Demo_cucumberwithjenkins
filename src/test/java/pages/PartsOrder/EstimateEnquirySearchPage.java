package pages.PartsOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utilities.CredsLoader;

import java.util.List;

public class EstimateEnquirySearchPage extends BasePage {

    public EstimateEnquirySearchPage(WebDriver driver) {
        super(driver);
    }

    private final By PartsOrderDropDown = By.xpath("(//div[@class='row'])[3]/div[2]/h4/b");
    private final By EstimateEnquirySearch = By.xpath("((//table[@class='tblaltclrmenuPanel'])[3]/tbody/tr[4]/th)[1]");
    private final By NewEstimateOrderBtn = By.id("newOrder");
    private final By EstimateTitle = By.xpath("//h4[text()='Estimate Order Search']");
    private final By AddItemBtn = By.id("cancelButtonbtn");
    private final By CustomerName = By.id("customerDL");
    private final By customerList = By.xpath("//ul[@unselectable=\"on\"]//li/div");
    private final By SaveBtn = By.id("saveButton");
    private final By ClickEditIcon = By.xpath("(//table[@id='myTable']/tbody/tr/child::td[i])[1]");
    private final By CreateOrderCheckBox = By.id("cbAll");
    private final By ClickCreateOrderBtn = By.xpath("(//a[@id='btnCreateorder'])[4]");
    private final By ClickSaveOrderBtn = By.id("newInvoice");
    private final By EditIconClick = By.xpath("(//table[@class='tblaltclr table-bordered']/tbody/tr/child::td[i])[3]");
    private final By UploadImage = By.xpath("(//table[@class='tblaltclr table-bordered']/tbody/tr/child::td[i])[2]");
    private final By UpdateOrderQuan = By.id("txtEditOrderQnty");
    private final By EnterRemarks = By.id("txtEditDescription");
    private final By ClickOkBtn = By.xpath("(//input[@id='btnEdit'])[1]");
    private final By ChooseFileBtn = By.id("imageSelect1");
    private final By ClickUploadImageBtn = By.id("imageSelect1Btn");
    private final By ClickCloseIcon = By.xpath("(//div[@id='allmodalDelete']/i)[6]");
    private final By addButton = By.id("btnAdd_4596257");
    private final By saveButton = By.xpath("(//input[@id='btnAddMaterialItem'])[2]");
    private final By ClickSearchIcon = By.xpath("(//span[@class='searchmobilebutton'])[2]");
    private final By partNumber = By.id("popproductCodeDl");
    private final By AddButton7 = By.id("btnAdd_55698948");
    private final By RefreshList = By.xpath("//input[@id='headerrefreshimg']");
    private final By SearchButton = By.id("search");
    private final By additionalItem = By.id("additionalItem");
    private final By updateItemStatus = By.id("updateItemStatusAll");
    private final By ClickSaveBtn = By.xpath("(//a[@id='btnCreateorder'])[3]");
    private final By RefreshList1 = By.xpath("//input[@id='headerrefreshimg']");
    private final By updateItemStatus1 = By.id("updateItemStatus");
    private final By dropdownMenuLink = By.xpath("(//a[normalize-space()='Update'])[1]");
    private final By UpdateStatus = By.xpath("(//a[@id='btnCreateorder'][1])[1]");
    private final By SendNotification = By.xpath("(//a[@id='btnItemnotification'])[1]");
    private final By SelectAssignTo = By.id("assignemployeeContainer");
    private final By UpdateAssignTo = By.xpath("(//a[@id='btnassignto'])[1]");
    private final By UpdateCheckboxAssignTo = By.id("cbAssignToAll");
    private final By UpdateETA = By.xpath("(//a[@id='btnCreateorder'])[2]");
    private final By EnterETA = By.id("updateETA");
    private final By ClickUploadImage = By.xpath("(//table[@id='invoicemyTable']/tbody/tr/td[position()=5])[1]");
    private final By ChooseFileButton = By.id("imageSelect1");
    private final By UploadImageButton = By.id("imageSelect1Btn");
    private final By ChooseFileButton1 = By.id("imageSelect2");
    private final By UploadImageButton1 = By.id("imageSelect2Btn");
    private final By ChooseFileButton2 = By.id("imageSelect3");
    private final By ChooseFileButton3 = By.id("imageSelect4");
    private final By UploadImageButton2 = By.id("imageSelect3Btn");
    private final By UploadImageButton3 = By.id("imageSelect4Btn");
    private final By EnquiryNo = By.id("inqnum2");
    private final By SelectStatus = By.id("orderStatus");
    private final By icon = By.xpath("//img[@id='headermenuicon']");
    private final By PartsTabDrop = By.xpath("(//div[@class='row'])[3]/div[2]/h4/b");
    private final By EnquirySearch = By.xpath("(//table[@class='tblaltclrmenuPanel'])[3]/tbody/tr[4]/th");
    private final By EnquiryInsurance = By.id("nav-contactsTab-tab");
    private final By EnquiryNumberI = By.id("inqnum2ins");
    private final By InsSearch = By.id("searchins");
    private final By FromDate = By.id("searchDateFrom");
    private final By ToDate = By.id("searchDateTo");
    private final By StockDetailsBtn = By.xpath("//input[@onclick='viewVendorStock(id)']");
    private final By selectBranch = By.id("companybranchDL");
    private final By HeaderId = By.xpath("(//h3[@id='allModalHeader'])[13]");

    public String SelectBranch() {
//        System.out.println(getTextOnElement(selectBranch));
        String text = getTextOnElement(HeaderId);
        // System.out.println(getTextOnElement(HeaderId));
        return text;
    }

    public void ClickStockDetails() {
        clickOnElement(StockDetailsBtn);
    }

    public void EstimateEnquiry() {
        waitFor();
        clickOnElement(PartsOrderDropDown);
        waitFor();
        clickOnElement(EstimateEnquirySearch);
        waitFor();

    }

    public void NewEstimateBtn() {
        clickOnElement(NewEstimateOrderBtn);
    }

    public boolean verifyTitle(String title) {
        boolean result = false;
        if (driver.findElement(EstimateTitle).getText().equals(title.trim())) {
            result = true;
        }
        return result;
    }

    public void ClickAddItemBtn() {
        clickOnElement(AddItemBtn);
    }

    public void enterCustomerNameTextbox(String name) {
        try {

            Thread.sleep(1000);
            enterTextOnElement(CustomerName, name);
            Thread.sleep(1000);
            driver.findElement(CustomerName).sendKeys(Keys.BACK_SPACE);
            Thread.sleep(1000);
            // driver.findElement(customerNameTextbox).sendKeys(Keys.BACK_SPACE);

            wait.until(ExpectedConditions.presenceOfElementLocated(customerList));
            List<WebElement> customers = driver.findElements(customerList);
            int ListOfCustomers = customers.size();
            System.out.println(ListOfCustomers);
            for (WebElement customer : customers) {
                System.out.println(customer.getText());
                if (customer.getText().contains(name)) {
                    Thread.sleep(1000);
                    customer.click();
                    break;
                    // customer.sendKeys(Keys.DOWN);

                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClickSaveBtn() {
        clickOnElement(SaveBtn);
    }

    public void clickEditIcon() {
        clickOnElement(ClickEditIcon);
        clickOnElement(RefreshList);

    }

    public void ClickCreateOrder() {
        clickOnElement(CreateOrderCheckBox);
    }

    public void clickCreateBtnInList() {
        Actions ag = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("(//a[@id='dropdownMenuLink'])[2]"));
        ag.doubleClick(category).build().perform();
        clickOnElement(ClickCreateOrderBtn);
    }

    public void ClickSaveOrderBtn() {
        clickOnElement(ClickSaveOrderBtn);
    }

    public void ClickEditIcon() {
        clickOnElement(EditIconClick);
    }

    public void ClickUploadImage() {
        clickOnElement(UploadImage);
        waitUntilElementIsDisplayed(ChooseFileBtn);
        driver.findElement(ChooseFileBtn)
                .sendKeys(System.getProperty("user.dir") + new CredsLoader().getProperty("Image_Data"));
    }

    public void clickAddBtn() {
        clickOnElement(addButton);
    }

    public void EnterQuan(String Quan, String text) {
        enterTextOnElement(UpdateOrderQuan, Quan);
        enterTextOnElement(EnterRemarks, text);
        clickOnElement(ClickOkBtn);
    }

    public void ClickUploadImageBtn() {
        clickOnElement(ClickUploadImageBtn);
    }

    public void CloseIcon() {
        clickOnElement(ClickCloseIcon);
    }

    public void ClickSaveButton() {
        clickOnElement(saveButton);
    }

    public void EnterPartNum(String value) {
        enterTextOnElement(partNumber, value);
        clickOnElement(ClickSearchIcon);
    }

    public void ClickAddButton7() {
        clickOnElement(AddButton7);
    }

    public void EnterInquiryNo(String val) {
        enterTextOnElement(EnquiryNo, val);
    }

    public void SelectOrderStatus2(String val) {
        selectFromDropDown(SelectStatus, val);
    }

//    public void uploadImageFileButton()
//    {
//        driver.findElement(ChooseFileButton).sendKeys(System.getProperty("user.dir")+new CredsLoader().getProperty("JPEG_IMAGE"));
//        clickOnElement(UploadImageButton);
//    }

    public void CheckUploadImage() {
        WebElement image1 = driver.findElement(By.id("imageSelect1Btn"));
        WebElement image2 = driver.findElement(By.id("imageSelect2Btn"));
        WebElement image3 = driver.findElement(By.id("imageSelect3Btn"));
        WebElement image4 = driver.findElement(By.id("imageSelect4Btn"));

        boolean uploadSuccessful = false; // Flag to track if an upload was successful

        try {
            if (image1.isDisplayed()) {
                driver.findElement(ChooseFileButton)
                        .sendKeys(System.getProperty("user.dir") + new CredsLoader().getProperty("JPEG_IMAGE"));
                clickOnElement(UploadImageButton);
                uploadSuccessful = true; // Mark as successful
            } else if (image2.isDisplayed()) {
                driver.findElement(ChooseFileButton1)
                        .sendKeys(System.getProperty("user.dir") + new CredsLoader().getProperty("JPEG_IMAGE"));
                clickOnElement(UploadImageButton1);
                uploadSuccessful = true;
            } else if (image3.isDisplayed()) {
                driver.findElement(ChooseFileButton2)
                        .sendKeys(System.getProperty("user.dir") + new CredsLoader().getProperty("JPEG_IMAGE"));
                clickOnElement(UploadImageButton2);
                uploadSuccessful = true;
            } else if (image4.isDisplayed()) {
                driver.findElement(ChooseFileButton3)
                        .sendKeys(System.getProperty("user.dir") + new CredsLoader().getProperty("JPEG_IMAGE"));
                clickOnElement(UploadImageButton3);
                uploadSuccessful = true;
            }

            if (!uploadSuccessful) {
                System.out.println("No upload options are displayed. Skipping image upload.");
                driver.findElement(By.xpath("//div[@id='openImagePopUp']//div/following-sibling::div/i")).click();
            }

        } catch (Exception e) {
            System.err.println("An error occurred during the image upload check: " + e.getMessage());
            // Log the error without failing the test
        }

    }

    private void uploadImage(String chooseFileButton, String uploadImageButton) {
        // Set the image path
        String imagePath = System.getProperty("user.dir") + new CredsLoader().getProperty("JPEG_IMAGE");

        // Upload the image
        driver.findElement(By.id(chooseFileButton)).sendKeys(imagePath);
        clickOnElement(UploadImageButton);

    }

    public void ClickImageUpload() {
        clickOnElement(ClickUploadImage);
    }

    public void ClickUpdateItemStatus(String val) {
        selectFromDropDown(updateItemStatus1, val);
    }

    public void ClickDropdownMenu() {
        waitFor();
        Actions ag = new Actions(driver);
        WebElement link = driver.findElement(By.xpath("(//a[normalize-space()='Update'])[1]"));
        ag.doubleClick(link).build().perform();
        clickOnElement(UpdateStatus);
    }

    public void SelectFromDateAndToDate(String FDate, String TDate) {
        datePicker(FromDate, FDate);
        datePicker(ToDate, TDate);
    }

    public void ClickSearch() {
        clickOnElement(SearchButton);
    }

    public void ClickAdditionalItem() {
        clickOnElement(additionalItem);
    }

    public void ClickUpdateItem() {
        clickOnElement(updateItemStatus);
    }

    public void clickSaveOptionInList() {
        handleLoading();
        clickOnElement(RefreshList);
        waitFor();
        clickOnElement(updateItemStatus);
        Actions ag = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("(//a[@id='dropdownMenuLink'])[2]"));
        waitUntilElementIsDisplayed(By.xpath("(//a[@id='dropdownMenuLink'])[2]"));
        ag.doubleClick(category).build().perform();
        clickOnElement(ClickSaveBtn);
    }

    public void clickSaveOptionInList1() {
        Actions ag = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("(//a[@id='dropdownMenuLink'])[2]"));
        waitUntilElementIsDisplayed(By.xpath("(//a[@id='dropdownMenuLink'])[2]"));
        ag.doubleClick(category).build().perform();
        clickOnElement(SendNotification);
    }

    public void clickSaveOptionInList2() {
        waitFor();
        clickOnElement(RefreshList);
        waitFor();
        Actions ag = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("(//a[@id='dropdownMenuLink'])[2]"));
        waitUntilElementIsDisplayed(By.xpath("(//a[@id='dropdownMenuLink'])[2]"));
        ag.doubleClick(category).build().perform();
        clickOnElement(ClickSaveBtn);
    }

    public void ClickUpdateAssignTo(String val) {
        selectFromDropDown(SelectAssignTo, val);
    }

    public void ClickDropdownMenu1() {
        waitFor();
        Actions ag = new Actions(driver);
        WebElement link = driver.findElement(By.xpath("(//a[normalize-space()='Update'])[1]"));
        ag.doubleClick(link).build().perform();
        clickOnElement(UpdateAssignTo);
    }

    public void UpdateAssignToCheckBox() {
        clickOnElement(UpdateCheckboxAssignTo);
    }

    public void ClickDropdownMenu2() {
        Actions ag = new Actions(driver);
        WebElement link = driver.findElement(By.xpath("(//a[normalize-space()='Update'])[1]"));
        ag.doubleClick(link).build().perform();
        clickOnElement(UpdateETA);
    }

    public void EnterETADate(String val) {
        datePicker(EnterETA, val);
    }

    public void ClickEnquirySearch() {
        clickOnElement(icon);
        waitFor();
        clickOnElement(PartsTabDrop);
        waitFor();
        clickOnElement(EnquirySearch);
    }

    public void ClickInsuranceTab() {
        clickOnElement(EnquiryInsurance);
    }

    public void SelectInsurance(String val) {

        enterTextOnElement(EnquiryNumberI, val);
        clickOnElement(InsSearch);

    }

}
