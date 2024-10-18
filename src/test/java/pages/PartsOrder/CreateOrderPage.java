package pages.PartsOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class CreateOrderPage extends BasePage {

    public CreateOrderPage(WebDriver driver) {
        super(driver);
    }

    private final By partsOrderDropdown = By.xpath("(//div[@class='row'])[3]/div[2]/h4/b");
    private final By CreateOrder = By.xpath("((//table[@class='tblaltclrmenuPanel'])[3]/tbody/tr[1]/th)[1]");
    private final By addItem_btn = By.xpath("//*[@onclick='addOrderItemPopUp()']");
    private final By OrderTitle = By.xpath("//h4[text()='Order']");
    private final By errorMessage = By.id("kEmpName-error");
    private final By cusName = By.id("customerDL");
    private final By customerList = By.xpath("//ul[@unselectable=\"on\"]//li/div");
    private final By DropdownList = By.id("kEmpName");
    private final By EnquiryNo = By.id("orderEnqNumber");
    private final By ClickIcon = By.xpath("//span[@onclick='searchpaymentdetails()']");
    private final By CommonItems = By.id("commonItemradio");
    private final By AddBtn = By.id("btnAdd_10971217");
    private final By AddBtn1 = By.id("btnAdd_11853752");
    private final By Quantity = By.id("txtitemQty-10971217");
    private final By Quan = By.id("txtitemQty-11853752");
    private final By SaveBtn = By.xpath("//input[@onclick='addSelectedItem()']");
    private final By saveOrderBtn = By.id("newInvoice");
    private final By addBtn3 = By.id("btnAdd_4849904");
    private final By addBtn4 = By.id("btnAdd_38705488");
    private final By SearchIcon = By.xpath("(//span[@class='searchmobilebutton'])[2]");
    private final By SearchIcons = By.xpath("(//span[@class='searchmobilebutton'])[3]");
    private final By partNumber = By.id("popproductCodeDl");
    private final By selectMake = By.id("make_0");
    private final By OrderErrorMessage = By.id("orderEnqNumber-error");
    private final By PaymentType1 = By.xpath("//table[@id='myTable']/tbody/child::tr[1]/td[1]");
    private final By Limit1 = By.xpath("//table[@id='myTable']/tbody/child::tr[1]/td[2]");
    private final By NoOfDays1 = By.xpath("//table[@id='myTable']/tbody/child::tr[1]/td[3]");
    private final By OutstandingAmount1 = By.xpath("//table[@id='myTable']/tbody/child::tr[1]/td[4]");
    private final By PaymentType2 = By.xpath("//table[@id='myTable']/tbody/child::tr[2]/td[1]");
    private final By Limit2 = By.xpath("//table[@id='myTable']/tbody/child::tr[2]/td[2]");
    private final By NoOfDays2 = By.xpath("//table[@id='myTable']/tbody/child::tr[2]/td[3]");
    private final By OutstandingAmount2 = By.xpath("//table[@id='myTable']/tbody/child::tr[2]/td[4]");
    private final By PaymentButton = By.id("paymentDetails");
    private final By CloseIcon = By.xpath("(//div[@id='allmodalDelete']/i)[2]");
    private final By PlusButton = By.id("button1");
    private final By SelectVehicle = By.id("vehiclesearch");
    private final By SelectBrand = By.xpath("//div[@onclick=\"onMakeChange('AUDI')\"]");
    private final By SelectModel = By.xpath("//div[@onclick=\"onModelChange('A3')\"]");
    private final By SelectFuelType = By.xpath("//div[@onclick=\"onfuelChange('PETROL')\"]");
    private final By SelectYear = By.xpath("//div[@onclick=\"vehcileYearChange('2008')\"]");
    private final By SelectVariant = By.xpath("//div[@onclick=\"onVariantChange('(8P7) 1.6L TFSI','4547')\"]");
    private final By PartName = By.id("popproductDL");
    private final By SearchBtn = By.xpath("(//input[@id='btnAddMaterialItem'])[1]");
    private final By saveBtn = By.xpath("(//input[@id='btnAddMaterialItem'])[2]");
    private final By VehicleNumber = By.id("txtVehicleNumber");
    private final By PartNumber = By.id("partcodeable");
    private final By addBtn2 = By.id("btnAdd_55698948");

    public void createOrder() {
        waitFor();
        clickOnElement(partsOrderDropdown);
        waitFor();
        clickOnElement(CreateOrder);
        waitFor();

    }

    public void clickAddBtn() {
        clickOnElement(addBtn3);
    }

    public void ClickBtn() {
        clickOnElement(addBtn4);
    }

    public void addItem() {
        clickOnElement(addItem_btn);
    }

    public void SelectDropdown(String value) {
        selectFromDropDown(DropdownList, value);
    }

    public void ClickSearchIcon(String enquiryNo) {
        enterTextOnElement(EnquiryNo, enquiryNo);
        clickOnElement(ClickIcon);
    }

    public boolean verifyTitle(String title) {
        boolean result = false;
        if (driver.findElement(OrderTitle).getText().equals(title.trim())) {
            result = true;
        }
        return result;
    }

    public String ErrorMessage() {
        return getTextOnElement(errorMessage);
    }

    public String OrderErrorMessage() {
        return getTextOnElement(OrderErrorMessage);
    }

    public void enterNameTextbox(String name) {
        try {

            Thread.sleep(1000);
            enterTextOnElement(cusName, name);
            Thread.sleep(1000);
            driver.findElement(cusName).sendKeys(Keys.BACK_SPACE);
            Thread.sleep(1000);
            // driver.findElement(customerNameTextbox).sendKeys(Keys.BACK_SPACE);

            wait.until(ExpectedConditions.presenceOfElementLocated(customerList));
            List<WebElement> customers = driver.findElements(customerList);
            int listofcustomers = customers.size();
            System.out.println(listofcustomers);
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

    public void ClickCommonItems() {
        clickOnElement(CommonItems);
    }

    public void ClickAddBtn() {
        clickOnElement(AddBtn);
        clickOnElement(AddBtn1);
    }

    public void EnterQuantity(String value1, String value2) {
        enterTextOnElement(Quantity, value1);
        enterTextOnElement(Quan, value2);
    }

    public void ClickSave() {
        waitFor();
        WebElement scroll = driver.findElement(By.xpath("//input[@onclick='addSelectedItem()']"));
        scrollToElement(scroll);
        clickOnElement(SaveBtn);

    }

    public void ClickSaveOrderBtn() {

        clickOnElement(saveOrderBtn);
    }

    public void EnterPartNumber(String value) {
        enterTextOnElement(partNumber, value);

    }

    public void ClickSearchIconPartNumber() {
        clickOnElement(SearchIcons);
    }

    public void SelectDropdownMake(String val) {
        selectFromDropDown(selectMake, val);
    }

    public boolean getPaymentDetails1() {
        getTextOnElement(PaymentType1);
        getTextOnElement(Limit1);
        getTextOnElement(NoOfDays1);
        getTextOnElement(OutstandingAmount1);
        System.out.println("the payment type is:- " + getTextOnElement(PaymentType1));
        System.out.println("the limit amount of customer is:-" + getTextOnElement(Limit1));
        System.out.println("the total number of days of customer:-" + getTextOnElement(NoOfDays1));
        System.out.println("the outstanding amount of customer:-" + getTextOnElement(OutstandingAmount1));
        System.out.println("the payment type is:- " + getTextOnElement(PaymentType2));
        System.out.println("the limit amount of customer is:-" + getTextOnElement(Limit2));
        System.out.println("the total number of days of customer:-" + getTextOnElement(NoOfDays2));
        System.out.println("the outstanding amount of customer:-" + getTextOnElement(OutstandingAmount2));

        return true;
    }

    public void clickPaymentButton() {
        clickOnElement(PaymentButton);
    }

    public void ClickCloseIcon() {
        clickOnElement(CloseIcon);
    }

    public void ClickPlusButton() {
        clickOnElement(PlusButton);
    }

    public void ClickVehicleButton() {
        clickOnElement(SelectVehicle);
    }

    public void selectVehicleDetails() {
        clickOnElement(SelectBrand);
        clickOnElement(SelectModel);
        clickOnElement(SelectFuelType);
        clickOnElement(SelectYear);
        clickOnElement(SelectVariant);
    }

    public void clickCategory() {
        Actions ag = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("(//div[normalize-space()='Front Brake Pads'])[1]"));
        ag.doubleClick(category).build().perform();
    }

    public void ClickSaveBtn() {
        WebElement ele = driver.findElement(By.xpath("(//input[@id='btnAddMaterialItem'])[2]"));
        scrollToElement(ele);
        clickOnElement(saveBtn);

    }

    public void EnterVehicleNumber(String value) {

        enterTextOnElement(VehicleNumber, value);
    }

    public void ClickSearchIcon() {
        clickOnElement(SearchIcon);
    }

    public void ClickPartNumber() {
        clickOnElement(PartNumber);
    }

    public void clickAddBtn1() {

        clickOnElement(addBtn2);
    }

    public void EnterPartName(String value) {
        enterTextOnElement(PartName, value);
        clickOnElement(SearchBtn);
    }

}
