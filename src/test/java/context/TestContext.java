package context;

import dbhelper.DbExecutor;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.Customer.CustomerPage;
import pages.Customer.SearchByCodePage;
import pages.Dashboard.HomePage;
import pages.Login.LoginPage;
import pages.MyAccount.AccountPage;
import pages.PartsOrder.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

public class TestContext {
    public WebDriver driver;
    public CredsLoader credsLoader;
    public ConfigLoader configLoader;
    public Scenario scenario;
    public LoginPage loginPage;
    public CustomerPage customerPage;
    public HomePage homepage;
    public DbExecutor dbExecutor;
    public AccountPage accountpage;
    public SearchByCodePage searchByCodePage;
    public BulkUploadPage bulkUploadPage;
    public CreateOrderPage createOrderpage;
    public OrderSearchPage orderSearchPage;
    public EstimateEnquirySearchPage estimateEnquirySearchPage;
    public EstimateEnquiryDetailsPage estimateEnquiryDetailsPage;

}
