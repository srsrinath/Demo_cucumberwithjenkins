package pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {

    private final By userNameTextBox = By.xpath("//input[@id='txtLoginId']");
    private final By passwordTextBox = By.id("txtLgPassword");
    private final By txtCode = By.id("txtCode");
    private final By loginButton = By.id("btnSubmit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToApplication(String username, String password, String code) {
        enterTextOnElement(userNameTextBox, username);
        enterTextOnElement(passwordTextBox, password);

        enterTextOnElement(txtCode, code);
    }

    public void clickSubmit() {
        clickOnElement(loginButton);
    }

}
