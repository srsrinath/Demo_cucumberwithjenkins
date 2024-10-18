package hooks;

import context.TestContext;
import dbhelper.DbExecutor;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.Customer.CustomerPage;
import pages.Customer.SearchByCodePage;
import pages.Dashboard.HomePage;
import pages.Login.LoginPage;
import pages.MyAccount.AccountPage;
import pages.PartsOrder.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static dbhelper.DbConfig.initilizeDb;

public class Hooks {
    private WebDriver driver;
    private final TestContext context;
    private static Map<String, String> testData;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverFactory.initializeDriver();
        // initilizeDb();
        context.driver = driver;
        context.credsLoader = new CredsLoader();
        context.configLoader = new ConfigLoader();
        context.scenario = scenario;
        System.out.println("entering into the method");
        context.loginPage = new LoginPage(context.driver);
        context.customerPage = new CustomerPage(context.driver);
        context.homepage = new HomePage(context.driver);
        context.accountpage = new AccountPage(context.driver);
        context.scenario = scenario;
        context.searchByCodePage = new SearchByCodePage(context.driver);
        context.bulkUploadPage = new BulkUploadPage(context.driver);
        context.orderSearchPage = new OrderSearchPage(context.driver);
        context.createOrderpage = new CreateOrderPage(context.driver);
        context.estimateEnquiryDetailsPage = new EstimateEnquiryDetailsPage(context.driver);
        context.estimateEnquirySearchPage = new EstimateEnquirySearchPage(context.driver);
        // context.dbExecutor=new DbExecutor();

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        // Take screenshot if the scenario failed
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }

        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "Screenshot");
        }

        // closeDriver();

        driver.quit();
    }

}
