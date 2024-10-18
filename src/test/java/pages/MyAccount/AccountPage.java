package pages.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private final By icon = By.xpath("//img[@id='headermenuicon']");
    private final By account = By.xpath("//b[text()='My Account']");
    private final By changePassword = By.xpath("//th[text()='Change Password']");
    private final By saveBtn = By.id("change-pwd-save");
    private final By cpd = By.id("txtCurrentPwd");
    private final By pwn = By.id("txtPwd");
    private final By confirmPassword = By.id("txtConfirmPwd");
    private final By logout = By.xpath("//th[text()='Logout']");

    public void clickAccount() {
        clickOnElement(icon);
        clickOnElement(account);

    }

    public void clickConfirmPassword() {
        clickOnElement(changePassword);
    }

    public void ClickSaveBtn() {
        clickOnElement(saveBtn);
    }

    public void enterPasswordDetails(String cPwd, String nPwd, String cnPwd) {
        enterTextOnElement(cpd, cPwd);
        enterTextOnElement(pwn, nPwd);
        enterTextOnElement(confirmPassword, cnPwd);
    }

    public void clickLogout() {
        clickOnElement(logout);

    }
}
