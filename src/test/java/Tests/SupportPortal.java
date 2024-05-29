package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverManager;
import utils.UserCredentials;

import java.util.concurrent.TimeUnit;

public class SupportPortal {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private MyProfile myProfile;
    private Dashboard dashboard;
    private RaiseSupportIssue raiseSupportIssue;

    private static final String APP_URL = UserCredentials.getAppURL();

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver("Edge");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        raiseSupportIssue = new RaiseSupportIssue(driver);
        myProfile = new MyProfile(driver);

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void navigateToLoginPage() throws InterruptedException {
        driver.get(APP_URL);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        homePage.clickLoginButton();
        Assert.assertTrue(driver.getTitle().contains("Login"), "Login page is not displayed");
    }

    @Test(priority = 2, dependsOnMethods = "navigateToLoginPage")
    public void performLogin() {
        loginPage.enterUsername(UserCredentials.getUsername());
        loginPage.enterPassword(UserCredentials.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue(dashboard.logoDisplay(), "Login failed or dashboard logo not displayed");
    }

    @Test(priority = 3, dependsOnMethods = "performLogin")
    public void verifyDashboardElements() {
        Assert.assertTrue(dashboard.logoDisplay(), "Logo is missing");
        Assert.assertTrue(dashboard.homelinkDisplay(), "Home link is missing");
        Assert.assertTrue(dashboard.profileDisplay(), "My Profile link is missing");
        Assert.assertTrue(dashboard.rasieSupportDisplay(), "Support ticket link is missing");
        Assert.assertTrue(dashboard.searchButtonDisplay(), "Search button is missing");
        Assert.assertTrue(dashboard.notifiactionButtonDisplay(), "Notification button is missing");
        Assert.assertTrue(dashboard.profileButtonDisplay(), "Profile button is missing");
        Assert.assertTrue(dashboard.searchBarDisp(), "Search bar is missing");
        Assert.assertTrue(dashboard.featureTabdisolay(), "Featured tab is missing");
        Assert.assertTrue(dashboard.discussionTabDisp(), "Discussion tab is missing");
        Assert.assertTrue(dashboard.myFeedDisp(), "My Feed tab is missing");
    }

    @Test(priority = 4, dependsOnMethods = "verifyDashboardElements")
    public void raiseSupportIssue() throws InterruptedException {
        raiseSupportIssue.clickRaiseSupportLink();
        Assert.assertTrue(driver.getTitle().contains("Support"), "Raise Support Issue page is not displayed");
        Assert.assertTrue(raiseSupportIssue.pageTitle1Displayed(),"page title is not displayed");
        Assert.assertTrue(raiseSupportIssue.subTitle1Displayed(), "Subtitle 1 is not displayed");
        Assert.assertTrue(raiseSupportIssue.pageTitle2Displayed(), "Page title 2 is not displayed");
        Assert.assertTrue(raiseSupportIssue.subTitle2Displayed(), "Subtitle 2 is not displayed");

        // Verify Each Option is displayed
        Assert.assertTrue(raiseSupportIssue.accountTextDisplay(), "Case Origin option is not displayed");
        Assert.assertTrue(raiseSupportIssue.caseOriginDisplayed(), "Case Origin option is not displayed");
        Assert.assertTrue(raiseSupportIssue.caseReasonDisplayed(), "Case Reason option is not displayed");
        Assert.assertTrue(raiseSupportIssue.productDisplayText(), "Product option is not displayed");
        Assert.assertTrue(raiseSupportIssue.subjectDisplayText(), "Subject option is not displayed");
        Assert.assertTrue(raiseSupportIssue.descriptionDisplayText(), "Description option is not displayed");
        Assert.assertTrue(raiseSupportIssue.priorityDisplayText(), "Priority option is not displayed");
        Assert.assertTrue(raiseSupportIssue.escalatedDisplayText(), "Escalated option is not displayed");
        Assert.assertTrue(raiseSupportIssue.statusDisplayText(), "Status option is not displayed");
        Assert.assertTrue(raiseSupportIssue.uploadFileOption(), "Upload File option is not displayed");
    }

    @Test(priority = 5, dependsOnMethods = "raiseSupportIssue")
    public void caseOriginDropdown(){
        raiseSupportIssue.caseOriginDropdownClick();
        raiseSupportIssue.printCaseOriginDropdownOptions();
        raiseSupportIssue.selectCaseOrigin("Email");
    }


    @Test(priority = 6, dependsOnMethods = "caseOriginDropdown")
    public void selectOptionFromDropdown() throws InterruptedException {
        // Step 1: Open the dropdown
        raiseSupportIssue.caseReasonDropdownClick();

        // Step 2: Print all options
        raiseSupportIssue.printCaseReasonDropdownOptions();

        // Optional: Wait to ensure options are loaded properly
        Thread.sleep(1000);

        // Step 3: Select the "Installation" option
        raiseSupportIssue.selectCaseReasonUsingKeyboard("Installation");
    }
}
