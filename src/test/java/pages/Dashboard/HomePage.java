package pages.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By refreshCustomer = By.xpath("//*[@value=\"Refresh Customer list\"]");
    private final By refreshWorkshop = By.xpath("//input[@value='Refresh Workshop list']");

    public void clickRefreshCustomerList() {
        clickOnElement(refreshCustomer);
    }

    public void clickRefreshWorkshopList() {
        clickOnElement(refreshWorkshop);
    }

}
