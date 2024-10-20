package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

import utilities.CredsLoader;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final String mainWindowHandle;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.mainWindowHandle = driver.getWindowHandle();
    }

    public boolean isLoginSuccessful() {
        // Check if login was successful
        // For example, check if the user is redirected to the homepage or if an error
        // message is displayed
        try {
            return driver.findElement(By.id("someElementThatIndicatesLoginSuccess")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void goTo(String url) {
        driver.get(url);
        waitFor();
    }

    public void clickOnElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }

    public void enterTextOnElement(By element, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }

    public void switchToNewTabAndClose() {
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the last opened window
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break; // Switch to the first new tab found
            }
        }

        // Close the new tab
        driver.close();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);
    }

    public WebDriver openNewIncognitoWindow(WebDriver driver) {
        // Open a new tab
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");

        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        WebDriver newTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        // Optionally, set incognito mode for the new tab
        // Note: Depending on browser behavior, incognito mode might not be applied to
        // the new tab.
        return newTab;
    }

    public void clickElementById(String elementId) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById(arguments[0]).click();", elementId);
        } catch (Exception e) {
            System.out.println("Element with ID " + elementId + " not found or not clickable.");
            e.printStackTrace();
        }
    }

    public void clickedit(By element) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("Element with ID " + element + " not found or not clickable.");
            e.printStackTrace();
        }
    }

    public void clickElementByIdAndIndex(String elementId, int index) {
        try {
            // Find all elements with the specified ID
            List<WebElement> elements = driver.findElements(By.id(elementId));

            // Check if the index is valid
            if (index < 0 || index >= elements.size()) {
                System.out.println("Index out of bounds. Available elements: " + elements.size());
                return;
            }

            // Click the specified element
            elements.get(index).click();
        } catch (Exception e) {
            System.out.println("Error clicking element with ID " + elementId + " at index " + index);
            e.printStackTrace();
        }
    }

    public String getPlaceholderText(WebDriver driver, String elementId) {
        WebElement inputField = driver.findElement(By.id(elementId));
        return inputField.getAttribute("placeholder");
    }

    public void moveToElementAndClick(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        WebElement webElement = driver.findElement(element);
        Actions act = new Actions(driver);
        act.moveToElement(webElement).click().build().perform();
    }

    public String getTextOnElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilElementIsDisplayed(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void selectFromDropDown(By dropDown, String value) {
        // clickOnElement(dropDown);
        waitUntilElementIsDisplayed(dropDown);
        Select objSelect = new Select(driver.findElement(dropDown));
        objSelect.selectByVisibleText(value);
    }

    public boolean verifyAlertMessage(String textMessage) {
        boolean result = false;
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.alertIsPresent());

        String textmessage = driver.switchTo().alert().getText();
        if (textmessage.contains(textMessage)) {
            result = true;
        }
        driver.switchTo().alert().accept();
        return result;
    }

    public void datePicker(By date, String datetext) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]", driver.findElement(date), datetext);
    }

    public String dynamicLocators(String path, String value) {
        return String.format(path, value);
    }

    public void scroolInToView(By element) {
        JavascriptExecutor jc = (JavascriptExecutor) driver;
        jc.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String todaysDate() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return today.format(formatter);
    }

    public String getDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = currentDate.plusDays(2);
        return date.format(formatter);
    }

    public boolean comapreDateAndTime(String userdateandtime, String currentdateandtime) {
        boolean result = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime userDateTime = LocalDateTime.parse(userdateandtime, formatter);
        LocalDateTime currentDateTime = LocalDateTime.parse(currentdateandtime, formatter);
        System.out.println("userdateandtime" + userdateandtime);
        System.out.println("currentdateandtime" + currentdateandtime);
        if (Math.abs(ChronoUnit.MINUTES.between(currentDateTime, userDateTime)) <= 1) {
            result = true;
        }
        return result;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000 - 1 + 1) + 1;
    }

    public static String decrypt(String encryptedMobile) throws Exception {
        String SECRET_KEY = "abcdefghijklmnopqrstuvwx";
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMobile));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static String getMobileNumber() {
        Random rand = new Random();
        StringBuilder mobileNumber = new StringBuilder("");

        int startDigit = rand.nextInt(4) + 6;
        mobileNumber.append(startDigit);

        for (int i = 0; i < 9; i++) {
            mobileNumber.append(rand.nextInt(10));
        }

        return mobileNumber.toString();
    }

    public static String getRandomName() {
        Faker faker = new Faker();
        String randomName = faker.name().fullName();
        return randomName;
    }

    public static String generateRandomGSTIN() {
        Random rand = new Random();

        String stateCode = String.format("%02d", rand.nextInt(37));

        StringBuilder panNumber = new StringBuilder();
        panNumber.append((char) (rand.nextInt(26) + 'A'));
        for (int i = 0; i < 4; i++) {
            panNumber.append((char) (rand.nextInt(26) + 'A'));
        }
        panNumber.append(rand.nextInt(10));

        String entityCode = String.format("%02d", rand.nextInt(100));

        String gstinWithoutChecksum = stateCode + panNumber.toString() + entityCode;
        int[] weights = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };
        int total = 0;
        for (int i = 0; i < gstinWithoutChecksum.length(); i++) {
            int digit = Character.getNumericValue(gstinWithoutChecksum.charAt(i));
            total += (digit / 10 + digit % 10) * weights[i];
        }
        int checksum = (10 - (total % 10)) % 10;

        return stateCode + panNumber.toString() + entityCode + checksum;
    }

    public static String getRandomEmail() {
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();
        return randomEmail;
    }

    public void redirectToPage(String pagename) {
        switch (pagename) {
            case "HOME_DASHBOARD":
                driver.get(new CredsLoader().getProperty("Homedashboard"));
                waitFor();
                break;

            case "CREATEPARTS":
                driver.get(new CredsLoader().getProperty("CREATE_ORDER"));
                break;
            default:
                System.out.println("Invalid page name");
        }

    }

    public void waitFor() {
        try {
            Thread.sleep(6000);
        } catch (Exception e) {

        }
    }

    public void handleLoading() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                .equals("complete"));
    }

    public String getSelectedOption(By xpathdata) {
        Select dropdown = new Select(driver.findElement(xpathdata));
        WebElement element = dropdown.getFirstSelectedOption();
        return element.getText();
    }

    public static String generateRandomEmailId() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        int localPartMaxLength = 15;
        String domain = "@asia.com";

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int localPartLength = Math.min(localPartMaxLength - domain.length(), 10); // Ensure local part is within limits
        for (int i = 0; i < localPartLength; i++) {
            int index = random.nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(index));
        }

        sb.append(domain);

        return sb.toString();
    }

    public boolean verifyUrl(String pageUrl) {
        String url = driver.getCurrentUrl();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(10));
        wait1.until(ExpectedConditions.urlToBe(pageUrl));
        boolean result = false;
        if (url.equals(pageUrl)) {
            result = true;
        }
        return result;
    }

    public String getValueFromTextBox(WebElement textBox) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String value = (String) js.executeScript("return arguments[0].value;", textBox);
        System.out.println("Text in the textbox: " + value);
        return value;
    }

}
