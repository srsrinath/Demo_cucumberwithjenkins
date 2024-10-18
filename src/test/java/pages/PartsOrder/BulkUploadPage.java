package pages.PartsOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import scenarios.stepDefinitions.PartsOrder.BulkOrderStepDef;
import utilities.CredsLoader;

import java.util.List;

import static utilities.ExcelReader.getRowData;

public class BulkUploadPage extends BasePage {

    private final By dataUploadTitle = By.xpath("//h4[text()='DATA UPLOAD']");
    private final By uploadButton = By.id("uploadFile");
    private final By icon = By.xpath("//img[@id='headermenuicon']");
    private final By partsOrderDropdown = By.xpath("(//div[@class='row'])[3]/div[2]/h4/b");
    private final By BulkDataUpload = By.xpath("(//table[@class='tblaltclrmenuPanel'])[3]/tbody/tr[5]/th");
    private final By customerNameTextbox = By.id("comBranchDL");
    private final By searchButton = By.id("search");
    private final By chooseFileButton = By.id("uploadFileSelect");

    private final By customerList = By.xpath("//ul[@unselectable=\"on\"]//li/div");

    public String partName = "//td[contains(text(),'%s')]/preceding-sibling::td[2]";

    public String partCode = "//td[contains(text(),'%s')]";

    private final By saveButton = By.id("addEstimateOrder");
    private final By searchOrderId = By.id("myInput");
    public String orderNumber = "(//table[@id=\"myTable\"]/tbody/tr[count(following-sibling::tr) < 4])[1]/td[5]";

    public BulkUploadPage(WebDriver driver) {
        super(driver);
    }

    public void PartsOrderTab() {
        clickOnElement(icon);

    }

    public void PartsOrderOption() {
        clickOnElement(partsOrderDropdown);
        clickOnElement(BulkDataUpload);
    }

    public boolean verifyTitle(String title) {
        boolean result = false;
        if (driver.findElement(dataUploadTitle).getText().equals(title.trim())) {
            result = true;
        }
        return result;
    }

    public void enterNameTextbox(String name) {
        try {

            Thread.sleep(1000);
            enterTextOnElement(customerNameTextbox, name);
            Thread.sleep(1000);
            driver.findElement(customerNameTextbox).sendKeys(Keys.BACK_SPACE);
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
        waitUntilElementIsDisplayed(chooseFileButton);
        driver.findElement(chooseFileButton)
                .sendKeys(System.getProperty("user.dir") + new CredsLoader().getProperty("EXCEL_DATA"));
    }

    public void clickUploadButton() {
        clickOnElement(uploadButton);
    }

    public boolean verifyData() {
        boolean result = false;
        try {

            List<List<String>> data = getRowData(new CredsLoader().getProperty("SHEET_NAME"));
            Thread.sleep(1000);
            for (int i = 0; i < data.size(); i++) {
                System.out.println("*************"
                        + driver.findElement(By.xpath(dynamicLocators(partCode, data.get(i).get(0).trim()))).getText());
                System.out.println("$$$$$$$$$$$$" + data.get(i).get(0));
                System.out.println("&&&&&&&&&&&&" + dynamicLocators(partCode, data.get(i).get(0).trim()));
                if (driver.findElement(By.xpath(dynamicLocators(partCode, data.get(i).get(0)))).getText()
                        .equals(data.get(i).get(0))
                        && driver.findElement(By.xpath(dynamicLocators(partCode, data.get(i).get(1)))).getText()
                                .equals(data.get(i).get(1))) {
                    result = true;
                }
            }
        } catch (Exception e) {

        }

        return result;

    }

    public void clickSaveButton() {
        clickOnElement(saveButton);

    }

    public void clickSearchButton() {

        clickOnElement(searchButton);
        waitFor();
        enterTextOnElement(searchOrderId, BulkOrderStepDef.orderNumber);
    }

    public String getOrderNumber() {
        waitUntilElementIsDisplayed(By.xpath(orderNumber));
        return driver.findElement(By.xpath(orderNumber)).getText();
    }

}
